package Junit.单元测试Test; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* Teacher Tester. 
* 
* @author <ZhangHao> 
* @since 九月 19, 2019  
* @version 1.0 
*/ 
public class TeacherTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: talk() 
* 
*/ 
@Test
public void testTalk() throws Exception {
    System.out.println("6666666666");
} 

/** 
* 
* Method: getId() 
* 
*/ 
@Test
public void testGetId() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setId(int id) 
* 
*/ 
@Test
public void testSetId() throws Exception { 
//TODO: Test goes here... 
} 


} 
