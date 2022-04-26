<body>
<header>
<h1 class="title" style="text-align: center;">Book Store with Recommendation System</h1>

</header>
<br>
<h2 id="introduction">Introduction</h2>
<p>The Internet by far plays a major role in people’s life. It has drastically improved the quality of life and the standard of living of so many people. It has widened its branches into many different levels and areas. The e-commerce business is one such branch that has gotten a lot of attention recently. Traditional bookstores are not always accessible; they are limited by their hours of operation, the availability of specific books, their location, and, most crucially, their capacity and the space required to store a large number of books. As a result of these disadvantages, e-commerce sectors have evolved. Such drawbacks have led to the evolution of e-commerce industries related to bookstores. Our project is a simple website that includes a variety of books in various categories for consumers to view online.</p>
<p>With the growth of Youtube, Amazon, Netflix, and other similar web services over the last several decades, recommender systems have become increasingly important in our lives. Recommender systems are becoming ubiquitous in our everyday online journeys, from e-commerce (suggest articles to buyers that may be of interest) to online advertising (suggest the suitable contents to users based on their preferences). Recommender systems, in a broad sense, are algorithms that try to propose relevant items to consumers (items being movies to watch, text to read, products to buy or anything else depending on industries). In certain businesses, recommender systems are crucial since they may produce a large amount of revenue or serve as a method to differentiate yourself from rivals. As an example of the importance of recommender systems, Netflix held a competition (the "Netflix prize") a few years ago in which the objective was to create a recommender system that outperformed its own algorithm, with a reward of one million dollars on the line. </p>
<p>The main goal of this project is to make an online book recommendation system and examine the performance of the machine learning algorithm on a publicly available dataset from Kaggle. Weka API is used as the main tool to evaluate and recommend the books from the dataset.</p>
<p>Businesses rely on data scientists to derive insight from their enormous, ever-expanding, diverse set of data in today’s Big Data era. Many people think of data science as a job, but it’s more accurate to think of it as a way of thinking, a technique of extracting insights through the scientific process.  Our personal motivation derives from our desire to work in the field of data science in the near future. As a result, we aim to get some practical experience from this project.</p>
<h2 id="problem-solving-and-algorithms">Problem solving and algorithms</h2>
<p>The Book dataset utilized in this project is available at Kaggle.com [1]. The dataset can be viewed as either classification or regression tasks. This dataset can be used for building book recommendation system as it contains all the information for each book in the dataset. The dataset contains 9 descriptive features and 6238 instances. Books are identified by their respective Title. Moreover, some content-based information is given (Author, Edition, Reviews, Ratings, Synopsis, Genre, Book Category, and Price)</p>
<p>Data cleaning is extremely important before utilizing the data. In this project, the data is preprocessed by identifying and handling duplicate data, anomalous data, and other inconsistencies that could skew the analysis. This will ultimately enhance the performance of the model. The Book dataset will serve as the foundation for our project's book recommendation engine, as it contains all of the necessary data.</p>
<p>Weka implements a relatively complete set of classification algorithms, including many of the most popular. In this project, state-of-the-art unsupervised classification algorithm, k-means algorithm is used. As different descriptive features may impact the classifiers’ performance, we clean the data before doing descriptive analysis.</p>
<h2 id="proposed-system-design">Proposed System Design</h2>
<h3 id="system-components">System components</h3>
<ul>
<li>
<b>Login page -</b> Authentication (Login) has two roles (Admin, Customer)
</li>
<li>
<b>Admin user login -</b> Allows admin to search a book, view the list of books, add a book, modify a book, and delete a book
</li>
<li>
<b>Regular user login -</b> Allows a regular user to search a book and view the list of books
<li>
<b>View (along with Recommended books) -</b> when a user clicks a book, it will display details of the selected book, on this page we will recommend similar books, related to the item the user is looking for.
</li>
</ul>
<h3 id="preliminary-technical-tools">Preliminary technical tools</h3>
<ul>
<li>
Eclipse
</li>
<li>
MySql
</li>
<li>
Java EE
</li>
<li>
Weka API
</li>
<li>
Enterprise JavaBeans (EJB)
</li>
<li>
JavaServer Pages (JSP)
</li>
<li>
WildFly
</li>
</ul>
  
  ![t2-01](https://user-images.githubusercontent.com/67748452/165386128-65832e01-7f2e-4f08-9c23-21e41b8e6f55.png)
![t2-02](https://user-images.githubusercontent.com/67748452/165386134-4cfa04bc-8d0c-4bbb-898e-cafd66c8cb38.png)
![t2-03](https://user-images.githubusercontent.com/67748452/165386150-4862c9e9-d84f-481d-9ced-873b49a59a99.png)
![t3-01](https://user-images.githubusercontent.com/67748452/165386155-b20cc089-3b7c-48d3-bdc1-69363f862b92.png)
![t4-01](https://user-images.githubusercontent.com/67748452/165386158-fa26c238-7f05-4414-b2aa-236b65b3ba42.png)
![t5-01](https://user-images.githubusercontent.com/67748452/165386163-338c36d9-f167-47f1-8b6c-bb575b805598.png)
![t5-02](https://user-images.githubusercontent.com/67748452/165386166-4baacec1-ac93-40bb-be5a-eafddbdd557c.png)
![t6-01](https://user-images.githubusercontent.com/67748452/165386170-ce70cc94-e6a1-45c5-9a82-b1ad94d0f8ad.png)
![t7-01](https://user-images.githubusercontent.com/67748452/165386172-f0932c2b-8d6b-4cfb-9eb4-d02f509f0b19.png)
![t7-02](https://user-images.githubusercontent.com/67748452/165386174-e6e86cd0-c701-49d3-9dd0-f2e90ab3df7b.png)
![t8-01](https://user-images.githubusercontent.com/67748452/165386177-60882ce0-e893-4f1b-bdc3-eafdd4bbc184.png)
![t8-02](https://user-images.githubusercontent.com/67748452/165386180-1e9feeff-1dd3-4854-a157-fdc5a3592628.png)
![t8-03](https://user-images.githubusercontent.com/67748452/165386182-91a5bd94-359d-4eb6-8a54-3695c53b525f.png)
![t8-04](https://user-images.githubusercontent.com/67748452/165386184-c5b57e23-1b97-4306-9fdc-72e1497e1f6d.png)
![t8-05](https://user-images.githubusercontent.com/67748452/165386186-44864bb3-de4a-4033-9a66-006938fbbecd.png)
![t8-06](https://user-images.githubusercontent.com/67748452/165386187-39a4959f-ec72-42b2-a4f5-67213309d4cc.png)
![t8-07](https://user-images.githubusercontent.com/67748452/165386188-b41db28d-f835-4e2e-9607-dfc538b8c090.png)
![t8-08](https://user-images.githubusercontent.com/67748452/165386190-7476d029-6537-4d9e-bc07-3154571523ba.png)
![t9-01](https://user-images.githubusercontent.com/67748452/165386192-d2f63c33-dbef-430e-8d16-0ad89ecd97b1.png)
![t9-02](https://user-images.githubusercontent.com/67748452/165386196-cac5fedb-c6c9-48db-a299-e12da7f5477a.png)
![t9-03](https://user-images.githubusercontent.com/67748452/165386200-d22708fe-95f9-4522-bff0-730ea417c686.png)
![t9-04](https://user-images.githubusercontent.com/67748452/165386201-51b08a4b-0d34-485f-acf8-293d59236fa9.png)
