# MVP Sample using RxJava, Retrofit and Dagger 2

### Specs
+ Infinite scroll list with the most popular tv shows. Using the following endpoint : http://docs.themoviedb.apiary.io/#reference/tv/tvtoprated/get
+ Each *item* of the list contain an **image**, the **tv show title** and the **vote average** fields.
+ The list **paginate**
+ If a **list item is clicked, it loads the tv show data in a detail view**.
+ Once in the detail view, the user is able to **navigate between similar tv shows** (http://docs.themoviedb.apiary.io/#reference/tv/tvidsimilar/get) by **swapping horizontally**. The first item is the one that the user has clicked. Then it loads the related tv shows and the user is able to navigate using swipe to left or right.