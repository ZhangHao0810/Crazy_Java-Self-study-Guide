package JDBC编程_MySql.Blob类型的操作_存储图片或者声音文件;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/26 18:21
 * @Description： MySQL中blob类型最多只能存储64k的内容，所以使用mediumblob类型，该类型可以存储16M的内容。
 * 这个演示中用到了Java自带的图形用户界面。
 *
 * #建表语句
 * create table img_table(
 *      img_id int auto_increment primary key,
 *      img_name varchar(255)
 *      img_data mediumblob
 * );
 *
 *
 * 测试之后，发现最终的程序并不完美。
 * 主要是了解和学习如何保存和提取二进制的文件
 */
public class BlobTest {
    JFrame jf = new JFrame("图片管理程序");
    private static Connection conn;
    private static PreparedStatement insert;
    private static PreparedStatement query;
    private static PreparedStatement queryAll;

    private DefaultListModel<ImageHolder> imageModel = new DefaultListModel<ImageHolder>();

    private JList<ImageHolder> imageList = new JList<>(imageModel);
    private JTextField filePath = new JTextField(26);
    private JButton browserBn = new JButton("...");
    private JButton uploadBn = new JButton("上传");
    private JLabel imageLabel = new JLabel();
    //  以当前路径创建文件选择器，
    JFileChooser chooser = new JFileChooser(".");
    //    创建文件过滤器
    ExtensionFileFilter filter = new ExtensionFileFilter();

    /**
     * @author Zhanghao
     * @date 2019/9/27 8:53

     * @Description:  静态代码块，类一旦被加载之后，就会执行。
    */
    static {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("mysql.ini"));
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);

//            对象执行插入之后会自动返回生成的主键。
            insert = conn.prepareStatement("insert into img_table values (null,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            query = conn.prepareStatement("select img_data from img_table where img_id=?");
            queryAll = conn.prepareStatement("select img_id, img_name from img_table");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() throws SQLException {
        filter.addExtension("jpg");
        filter.addExtension("jpeg");
        filter.addExtension("gif");
        filter.addExtension("png");
        filter.setDescription("图片文件( *.jpg, *.jpeg, *.gif, *.png)");
        chooser.addChoosableFileFilter(filter);

        chooser.setAcceptAllFileFilterUsed(true);
//        初始化界面
        fillListModel();
        filePath.setEditable(false);
//        单选
        imageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JPanel jPanel=new JPanel();
        jPanel.add(filePath);
        jPanel.add(browserBn);
        browserBn.addActionListener(event->{
            int result = chooser.showDialog(jf,"浏览图片,文件上传");
            if (result==JFileChooser.APPROVE_OPTION){
                filePath.setText(chooser.getSelectedFile().getPath());
            }
        });
        jPanel.add(uploadBn);
        uploadBn.addActionListener(avt->{
            if (filePath.getText().trim().length()>0 ){
                upload(filePath.getText());
                filePath.setText("");
            }
        });

        JPanel left = new JPanel();
        left.setLayout(new BorderLayout());
        left.add(new JScrollPane(imageLabel),BorderLayout.CENTER);
        left.add(jPanel,BorderLayout.SOUTH);
        jf.add(left);
        imageList.setFixedCellWidth(160);
        jf.add(new JScrollPane(imageList),BorderLayout.EAST);
        imageList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()>=2){
                    ImageHolder cur=(ImageHolder)imageList.getSelectedValue();
                    try {
                        showImage(cur.getId());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        jf.setSize(620,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }

    /**
     * @param
     * @return void
     * @author Zhanghao
     * @date 2019/9/26 20:00
     * @Description: 查找img_table 填充 ListModel
     */
    public void fillListModel() throws SQLException {
        try (
                ResultSet rs = queryAll.executeQuery()
        ) {
            imageModel.clear();
            while (rs.next()) {
                imageModel.addElement(new ImageHolder(rs.getInt(1), rs.getString(2)));
            }
        }
    }

    /**
     * @param fileName
     * @return void
     * @author Zhanghao
     * @date 2019/9/26 20:24
     * @Description: 将图片放入数据库
     */
    public void upload(String fileName) {
        String imageName = fileName.substring(fileName.lastIndexOf('\\') + 1, fileName.lastIndexOf('.'));
        File f = new File(fileName);
        try (
                InputStream is = new FileInputStream(f);
        ) {
            insert.setString(1, imageName);
            insert.setBinaryStream(2, is, (int) f.length());
            int affect = insert.executeUpdate();
            if (affect == 1) {
//                更新ListModel 显示最新的图片列表。
                fillListModel();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param id
     * @return void
     * @author Zhanghao
     * @date 2019/9/26 20:27
     * @Description: 根据图片 ID 显示图片
     */
    public void showImage(int id) throws SQLException {
        query.setInt(1, id);
        try (
                ResultSet rs = query.executeQuery()
        ) {
            if (rs.next()) {
                Blob imgBlob = rs.getBlob(1);
                ImageIcon icon=new ImageIcon(imgBlob.getBytes(1L,(int)imgBlob.length()));
                imageLabel.setIcon(icon);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        new BlobTest().init();
    }

}

class ExtensionFileFilter extends FileFilter {
    private String description = "";
    private ArrayList<String> extensions = new ArrayList<>();

    //自定义方法，用于添加文件扩展名
    public void addExtension(String extension) {
        if (!extension.startsWith(".")) {
            extension = "." + extension.toLowerCase();
        }
    }

    //        设置文件过滤器的描述文本
    public void setDescription(String aDescription) {
        description = aDescription;
    }

    //
    @Override//判断文件过滤器是否接受该文件
    public boolean accept(File f) {
        if (f.isDirectory()) return true;
        String name = f.getName().toLowerCase();
        for (String extension : extensions) {
            if (name.endsWith(extension)) {
                return true;
            }
        }
        return false;
    }

    @Override//返回文件过滤器的描述文本
    public String getDescription() {
        return description;
    }
}

class ImageHolder {
    private int id;
    private String name;

    public ImageHolder() {
    }

    public ImageHolder(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

}