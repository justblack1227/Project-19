package org.coursesimple.CourseBlog.config;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.coursesimple.CourseBlog.models.Account;
import org.coursesimple.CourseBlog.models.Authority;
import org.coursesimple.CourseBlog.models.Post;
import org.coursesimple.CourseBlog.services.AccountService;
import org.coursesimple.CourseBlog.services.AuthorityService;
import org.coursesimple.CourseBlog.services.PostService;
import org.coursesimple.CourseBlog.util.constants.Privillages;
import org.coursesimple.CourseBlog.util.constants.Roles;

@Component
public class SeedData implements CommandLineRunner{

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public void run(String... args) throws Exception {

       for(Privillages auth: Privillages.values()){
            Authority authority = new Authority();
            authority.setId(auth.getId());
            authority.setName(auth.getPrivillage());
            authorityService.save(authority);

       }
        
       Account account01 = new Account();
       Account account02 = new Account();
       Account account03 = new Account();
       Account account04 = new Account();

       account01.setEmail("user@user.com");
       account01.setPassword("pass987");
       account01.setFirstname("User");
       account01.setLastname("lastname");
       account01.setAge(25);
       account01.setDate_of_birth(LocalDate.parse("1990-01-01"));
       account01.setGender("Male");



       account02.setEmail("admin@coursesimple.org");
       account02.setPassword("pass987");
       account02.setFirstname("Admin");
       account02.setLastname("lastname");
       account02.setRole(Roles.ADMIN.getRole());
       account02.setAge(25);
       account02.setDate_of_birth(LocalDate.parse("1990-01-01"));
       account02.setGender("Famale");

       account03.setEmail("editor@editor.com");
       account03.setPassword("pass987");
       account03.setFirstname("Editor");
       account03.setLastname("lastname");
       account03.setRole(Roles.EDITOR.getRole());
       account03.setAge(55);
       account03.setDate_of_birth(LocalDate.parse("1975-01-01"));
       account03.setGender("Male");

       account04.setEmail("super_editor@editor.com");
       account04.setPassword("pass987");
       account04.setFirstname("Editor");
       account04.setLastname("lastname");
       account04.setRole(Roles.EDITOR.getRole());
       account04.setAge(40);
       account04.setDate_of_birth(LocalDate.parse("1980-01-01"));
       account04.setGender("Female");

       
       Set<Authority> authorities = new HashSet<>();
       authorityService.findById(Privillages.ACCESS_ADMIN_PANEL.getId()).ifPresent(authorities::add);
       authorityService.findById(Privillages.RESET_ANY_USER_PASSWORD.getId()).ifPresent(authorities::add);
       account04.setAuthorities(authorities);

       accountService.save(account01);
       accountService.save(account02);
       accountService.save(account03);
       accountService.save(account04);
       


       List<Post> posts = postService.findAll();
       if (posts.size() == 0){
            Post post01 = new Post();
            post01.setTitle("Model–View–Controller Framework");
            post01.setBody("""
  
    <h3><strong>Getting Started with Python</strong></h3>
    <p><a href="https://www.python.org/community/logos/python-logo-master-v3-TM.png"><img src="https://www.python.org/community/logos/python-logo-master-v3-TM.png" alt="" width="220"></a></p>
    <p>&nbsp;</p>
    <p>Python is widely recognized for its simplicity and readability, making it an ideal language for beginners. Its syntax closely resembles natural language, which helps new programmers understand and write code more easily.</p>
    <p><strong>Key Takeaways:</strong></p>
    <ul>
        <li><strong>Simple Syntax:</strong> Python uses clear and readable syntax, avoiding complex symbols and structures. For example, it uses indentation instead of braces to define code blocks.</li>
        <li><strong>Versatility:</strong> Python can be used for various applications, including web development, data analysis, machine learning, and automation. Its extensive libraries and frameworks support a wide range of uses.</li>
        <li><strong>Rich Libraries:</strong> Python’s Standard Library provides modules for common tasks, such as file handling and regular expressions. Additionally, PyPI offers thousands of third-party libraries to enhance Python's functionality.</li>
    </ul>
    <p>For a detailed guide on starting with Python, check out this <a href="https://example.com/python-beginner-guide">beginner’s guide</a>.</p>
    
    """);
            post01.setAccount(account01);
            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("Mastering JavaScript Promises");
            post02.setBody("""
  
    <h3><strong>Mastering JavaScript Promises</strong></h3>
    <p><a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Modules"><img src="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Modules/images/JavaScript.png" alt="" width="220"></a></p>
    <p>&nbsp;</p>
    <p>JavaScript’s asynchronous capabilities are crucial for creating dynamic web applications. Promises provide a way to handle asynchronous operations, improving the readability and maintainability of your code.</p>
    <p><strong>Key Concepts:</strong></p>
    <ul>
        <li><strong>Promises:</strong> A promise represents an eventual completion (or failure) of an asynchronous operation and its resulting value. Promises help manage operations like API requests and file processing in a more organized manner.</li>
        <li><strong>Async/Await:</strong> The `async` and `await` keywords simplify working with promises, making asynchronous code look and behave more like synchronous code. `async` functions return a promise, and `await` pauses execution until the promise is resolved.</li>
        <li><strong>Error Handling:</strong> Promises can handle errors using `.catch()`, while `async/await` uses `try/catch` blocks for a more natural error handling approach.</li>
    </ul>
    <p>Explore more about asynchronous programming in JavaScript with this <a href="https://example.com/javascript-promises">JavaScript promises guide</a>.</p>
    
    """);
            
            post02.setAccount(account02);
            postService.save(post02);

            Post post03 = new Post();
            post03.setTitle("Object-Oriented Programming in Java");
            post03.setBody("""
               <h3><strong>Object-Oriented Programming in Java</strong></h3>
    <p><a href="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Java_Logo.svg/1024px-Java_Logo.svg.png"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Java_Logo.svg/1024px-Java_Logo.svg.png" alt="" width="220"></a></p>
    <p>&nbsp;</p>
    <p>Java is a powerful object-oriented programming language that organizes software design around data, or objects, rather than functions and logic. It provides a robust framework for creating scalable and maintainable applications.</p>
    <p><strong>Core Concepts:</strong></p>
    <ul>
        <li><strong>Classes and Objects:</strong> Classes are blueprints for creating objects. An object is an instance of a class and contains data (fields) and methods (functions) that operate on the data.</li>
        <li><strong>Inheritance:</strong> Inheritance allows one class to inherit fields and methods from another class. This promotes code reusability and establishes a hierarchical relationship between classes.</li>
        <li><strong>Encapsulation:</strong> Encapsulation is the practice of bundling data and methods into a single unit or class, and restricting access to some of the object's components. This helps protect the data from unintended modifications.</li>
    </ul>
    <p>Learn more about object-oriented principles in Java through this <a href="https://example.com/java-oop">comprehensive Java tutorial</a>.</p>
    
            """);
            post03.setAccount(account01);
            postService.save(post03);

            Post post04 = new Post();
            post04.setTitle("Building UIs with React");
            post04.setBody("""
                      
              <h3><strong>Building UIs with React</strong></h3>
    <p><a href="https://reactjs.org/logo-og.png"><img src="https://reactjs.org/logo-og.png" alt="" width="220"></a></p>
    <p>&nbsp;</p>
    <p>React is a popular JavaScript library for building user interfaces. It focuses on creating reusable components and managing state efficiently, making it a powerful tool for developing dynamic web applications.</p>
    <p><strong>Important Topics:</strong></p>
    <ul>
        <li><strong>Components:</strong> React applications are built from components, which are modular and reusable units of the UI. Components can be functional or class-based, and they manage their own state and lifecycle.</li>
        <li><strong>Props:</strong> Props (short for properties) are immutable data passed from parent to child components. They allow components to receive and display dynamic data, making them versatile and reusable.</li>
        <li><strong>State Management:</strong> State is a mechanism for managing dynamic data within a component. React provides tools for handling state, enabling components to respond to user inputs and other events.</li>
    </ul>
    <p>For a deeper understanding of React components and props, check out this <a href="https://example.com/react-components">React components tutorial</a>.</p>
    
            """);
            
            post04.setAccount(account02);
            postService.save(post04);

            Post post05 = new Post();
            post05.setTitle("Introduction to Spring Boot");
            post05.setBody("""
            <h3><strong>Introduction to Spring Boot</strong></h3>
    <p><a href="https://spring.io/images/spring-boot.png"><img src="https://spring.io/images/spring-boot.png" alt="" width="220"></a></p>
    <p>&nbsp;</p>
    <p>Spring Boot is an extension of the Spring Framework that simplifies the setup and development of new Spring applications. It provides built-in features for creating stand-alone, production-ready applications with minimal configuration.</p>
    <p><strong>Highlights:</strong></p>
    <ul>
        <li><strong>Auto-Configuration:</strong> Spring Boot automatically configures your application based on the dependencies you add, reducing the need for manual setup and configuration.</li>
        <li><strong>Embedded Servers:</strong> Spring Boot includes embedded servers like Tomcat and Jetty, allowing you to run your application as a stand-alone Java application without needing an external server.</li>
        <li><strong>Microservices:</strong> Spring Boot is well-suited for developing microservices architectures. It integrates seamlessly with Spring Cloud, providing tools and frameworks for building scalable and distributed systems.</li>
    </ul>
    <p>For an in-depth introduction to Spring Boot, explore this <a href="https://example.com/spring-boot-intro">Spring Boot guide</a>.</p>
    
            """);
            post05.setAccount(account01);
            postService.save(post05);

            Post post06 = new Post();
            post06.setTitle("Mastering Git for Version Control");
            post06.setBody("""
              <h3><strong>Mastering Git for Version Control</strong></h3>
    <p><a href="https://git-scm.com/images/logos/downloads/Git-Logo-2Color.png"><img src="https://git-scm.com/images/logos/downloads/Git-Logo-2Color.png" alt="" width="220"></a></p>
    <p>&nbsp;</p>
    <p>Git is a distributed version control system that allows developers to track changes in their code, collaborate with others, and manage multiple versions of their projects. Understanding Git’s core commands and workflows is essential for modern software development.</p>
    <p><strong>Key Commands:</strong></p>
    <ul>
        <li><strong>git init:</strong> Initializes a new Git repository in your project directory, setting up the necessary files and configurations.</li>
        <li><strong>git add and git commit:</strong> Use `git add` to stage changes for commit and `git commit` to save those changes to the repository. Each commit should include a descriptive message of the changes made.</li>
        <li><strong>git push and git pull:</strong> `git push` uploads your local commits to a remote repository, while `git pull` fetches and merges changes from the remote repository into your local branch.</li>
    </ul>
    <p>For a comprehensive guide to Git commands and workflows, visit this <a href="https://example.com/git-basics">Git basics tutorial</a>.</p>
    
            """);
            
            post06.setAccount(account02);
            postService.save(post06);

       }
        
    }
    
}
