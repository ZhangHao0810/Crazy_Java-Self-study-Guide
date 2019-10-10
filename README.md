# Crazy_Java_Project


**本仓库是我为了系统的复习Java基础 于2019.9 建立的，有意整理成教程，供自己复习和他人学习。**  

*参考自 李刚的 《疯狂java讲义》.第三版 和 IT黑马、渡一教育的部分培训视频*

* **知识点是在编写实例的同时记录的，主要以源码中注释的形式呈现。**

* **包含了反射和注解的知识，有利于更好的理解Spring框架的IOC，DI等思想。**

---

![](好好学习.jpg)
![](java2.jpg)
![](好好学习.jpg)

---

Java基础知识学习的过程，也是我熟悉IDEA 熟悉MarkDown 熟悉Git GitHub的过程。  
所以本仓库不完美，但我会努力做到尽善尽美。希望读者见谅和指正。


## 传送门：

### 集合框架类

- ####  Collection

[迭代器Iterator](src/集合框架类Test/Collection/Iterator_foreach_Test.java)  

###### List
    
 [**List接口简介**](src/集合框架类Test/Collection/List/List)   
 [**ArrayList** ](src/集合框架类Test/Collection/List/List_Test.javat)   
 [**ArrayList和Vector**](src/集合框架类Test/Collection/List/ArrayList和Vector/ArrayList和Vector)  
 [**LinkedList**](src/集合框架类Test/Collection/List/LinkedList/LinkedList_Test)  
 [**LIst_Iterator的使用**](src/集合框架类Test/Collection/List/ListIterator_Test.java)   
 * [**线性表的性能分析**](src/集合框架类Test/Collection/List/线性表的性能分析)  

###### Queue

[**Queue队列**](src/集合框架类Test/Collection/Queue/Queue队列)  
[**Queue的实现类**：PriorityQueue]( src/集合框架类Test/Collection/Queue/PriorityQueue_Test.java) 

双端队列：Deque  
[**Deque模拟数据结构-队列**](src/集合框架类Test/Collection/Queue/Deque/ArrayDeque_Queue_Test.java)  
[**Deque模拟数据结构-栈**](src/集合框架类Test/Collection/Queue/Deque/ArrayDeque_Stack_Test.java)  

###### Set

[**Set** ](src/集合框架类Test/Collection/Set/Set) 

[**HashSet** ](src/集合框架类Test/Collection/Set/HashSet/HashSet_Test.java) 

[ **LinkedHashSet** ](src/集合框架类Test/Collection/Set/HashSet/LinkedHashSet/LinkedHashSet_Test.java) 
 
[**TreeSet**](src/集合框架类Test/Collection/Set/SortedSet接口/TreeSet)  

[**EnumSet**](src/集合框架类Test/Collection/Set/EnumSet)  

- #### Map

 [**HashMap**](src/集合框架类Test/Map/Map_Test.java)

[ **identityHashMap**](src/集合框架类Test/Map/HashMap和Hashtable/IdentityHashM/IdentityHashMap_Test.java) 

[**LinkedHashMap** ](src/集合框架类Test/Map/HashMap和Hashtable/LinkedHashMap/LinkedHashMap_Test.java) 

[**WeakHashMap**](src/集合框架类Test/Map/HashMap和Hashtable/WeakHashMap/WeakHashMap_Test.java) 

[**Properties**](src/集合框架类Test/Map/HashMap和Hashtable/Properties/Properties_Test.java) 

[**什么是Hashtable，HashMap和Hashtable的区别** ](src/集合框架类Test/Map/HashMap和Hashtable/HashMap和Hashtable) 


 [**SortedMap接口实现类：TreeMap**](src/集合框架类Test/Map/SortedMap接口/TreeMap/TreeMap_Test.java)  

[EnumMap](src/集合框架类Test/Map/EnumMap/EnumMap_Test.java)  
  


* #### Collections工具类

[**collections工具类**](src/集合框架类Test/Collections/Collections工具类) 

[**简单的扑克游戏**](src/集合框架类Test/Collections/一个简单的扑克牌游戏) 

[**Collections_Search**](src/集合框架类Test/Collections/Collections_SearchTest.java) 

[**Synchronized**](src/集合框架类Test/Collections/Synchronized_Test.java) 


* #### 古老的Enumeration类

[**Enumeration**](src/集合框架类Test/古老的Enumeration类/Enumeration)  

[**Enumeration_Test**](src/集合框架类Test/古老的Enumeration类/Enumeration_Test.java)  

* [***HashSet和HashMap的性能分析***](src/集合框架类Test/HashSet和HashMap的性能分析) ： 




### IO流 （未完待续......）
[ **Buffered Stream 操作** *（包含文件复制、File和Arrayl互相转换）*](src/IO流/BufferedStream)  

[**如何解决乱码问题？** *码表的相关知识*](src/IO流/Encode/EncodeDemo.java)  

[**File类**](src/IO流.File.FileDemo)

[**FileInputStream FileOutputStream**](src/IO流.File.FileDemo)  


***单元测试 Junit***


关于路径中的符号：/ 和 \：
    
    UNIX 操作系统设计了这种路径分隔法，它使用反斜杠：/。
    由于网络是首先应用在 UNIX 计算机之间的，至今为止，一半以上的网络服务器仍是使用UNIX 操作系统的，所以网址也沿用了反斜杠作路径分隔符。
    
    微软在开发 DOS 2.0 的时候，借鉴UNIX 中了这种目录结构，但由于 DOS 中，斜杠已经用来作为命令行参数的标志了（UNIX 中用的是“ - ”符），所以只得使用反斜杠："\"
    
    Windows 时代，很多时候已经没有命令行参数的干扰，加上网络使用的扩展，
    文件夹路径的斜杠和反斜杠大多时候可以互换，是没有什么影响的;
    但浏览器中斜杠就不能互换的原因在于:当今有一半以上的网络服务器仍是使用UNIX 操作系统;必须使用：反斜杠："/" 