package ru.itsjava.annotations.myjunit;

import ru.itsjava.annotations.myjunit.repannotation.*;

public class MyAwfulTest{
    @Before
    public void testBefore(){
        System.out.println("Тест Before");
    }
    @After
    public void testAfter(){
        System.out.println("Тест After");
    }
    @BeforeEach
    public void testBeforeEach(){
        System.out.println("Тест BeforeEach");
    }
    @AfterEach
    public void testAfterEach(){
        System.out.println("Тест AfterEach");
    }
    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Test
    public void test2(){
        System.out.println("test2");
    }
    @Test
    public void test3(){
        System.out.println("test3");
        throw new AssertionError();
    }
    @Test
    public void test4(){
        System.out.println("test4");
    }
    @Test
    public void test5(){
        System.out.println("test5");
    }
    @Test
    public void test6(){
        System.out.println("test6");
    }

}
