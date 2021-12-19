# dynamic-query
Large dynamic query/search - Using Entity Manager with createNativeQuery method - Mapping the result to DTO using SqlResultSetMapping

This solution is really good when we are dealing with a service that will perform a large search using different database tables.
If the query uses up to 4 tables, we can work with API Criteria.
If the query uses more than 4 tables and it is a static query, we  can work with nativeQuery (Query annotation) in JPA.
But, if the query uses more than 4 tables and it is too dynamic, this seems to be the best approach so far.

Here, we're passing the SqlResultSetMapping name as parameter/argument to the createNativeQuery method. This will mapper the getResultList to a specific DTO.
In order to work, we must put the SqlResultSetMapping annotation and parameters in an Entity class.

@SqlResultSetMapping(
    name = "queryResultSetMapping",
    classes ={
        @ConstructorResult (
            targetClass =QueryResponseDto.class,
    columns ={
        @ColumnResult(name ="studentId", type = Long.class),
        @ColumnResult(name ="studentName"),
        @ColumnResult(name ="studentLastname"),
        @ColumnResult(name ="studentAge", type = Integer.class)        
    }
        )
    }
)
@Entity
@Table(name = "tab_student4")
public class Student implements Serializable {..}

Note: If the result is exactly an entity, we don't need to use this SqlResultSetMapping. You can see implementation details in the query or entityManager documentation.

THIS MICROSSERVICE IS UPTATED WITH CLEAN CODE PATTERNS AND NO CODE SMELL (GLOBAL REFERENCE)

This service uses the following database script:

create table tab_student4 (
student_number int primary key,
student_name nvarchar2(250),
lastname NVARCHAR2(50),
student_age int,
zipcode NVARCHAR2(255),
school_id int references tab_school (school_id),
period_id int references tab_period (period_id),
payment_id int references tab_payment (payment_id));

create sequence student4_seq
MINVALUE 1
START WITH 1
INCREMENT BY 1;

create table tab_payment (
payment_id int primary key,
payment_type nvarchar2(250),
payment_description nvarchar2(250)
);

create table tab_period (
period_id int primary key,
period_name nvarchar2(250),
active_period number
);

create table tab_school (
school_id int primary key,
official_name nvarchar2(250),
num_classes int,
address NVARCHAR2(255),
num_teachers int);
