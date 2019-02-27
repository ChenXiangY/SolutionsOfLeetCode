package com.SqlSolutions;

/**
 * 使用Mysql,用字符串来表示的答案.
 * @author Chen Xiangyu
 * @version 1.0
 * @classname SqlSolutions
 * @date 2019/2/26
 */
public class SqlSolutions {
//    175题,组合两个表.
    String S175 = "select FirstName,LastName,City,State from Person left join Address on Person.PersonId = Address.PersonId;";
//    176题,第二高的薪水.
    String S176 = "select (select distinct salary from Employee order by salary desc limit 1,1) as SecondHighestSalary ;";
//    181题,找出比经理工资高的员工
    String S181 = "select t1.Name as Employee from employee as t1 inner join (select * from employee) as t2 where t1.ManagerId = t2.Id and t1.Salary > t2.Salary;";
//    182题,查找重复的电子邮箱.这题没写出来.
    String S182 = "select Email from Person group by Email having count(Email) > 1";
//    183题,从不订购的客户.
    String S183 = "select Name as Customers  from Customers where customers.id not in (select CustomerId  from Orders);";

}
