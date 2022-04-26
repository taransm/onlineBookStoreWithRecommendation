# onlineBookStoreWithRecommendation
<head>
    <title> Book Store with Recommendation System</title>
  <style type="text/css">
     h1 {
counter-reset: section;
}

h2 {
counter-reset: subsection; 
counter-increment: section;
}

h2:before {
content: counter(section) ". ";
counter-reset: subsection;
}

h3:before {
content: counter(section) "." counter(subsection) " ";
counter-increment: subsection;
}

table, th, td {
  border: 1px solid black;
}
body{
  font-size: 1.25em;
}
  </style>
  <link rel="stylesheet" href="proposal.css" />
  <!--[if lt IE 9]>
    <script src="//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv-printshiv.min.js"></script>
  <![endif]-->
</head>
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
<p>The project will be developed based on the EC components from the labs and assignments of the course, and use the following basic tools.</p>
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
