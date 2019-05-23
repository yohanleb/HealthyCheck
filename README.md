# HealthyCheck
<img src="img/broccoli.png" width="100" height="100" />

HealthyCheck is an Android app who uses OpenFoodFacts' API to check if your food is healthy

## Installation
- `git clone https://github.com/yohanleb/HealthyCheck.git`

- Open project in Android Studio

## Features

- MVC Architecture
- REST API Call
- Singleton for API Instance
- 3 activities
- Displaying a list in a RecyclerView
- Displaying a detail view of the item
- Gitflow
- Animations between two views
- Data stored in cache
- More features : 
	- Scanner view
	- Material Cards
	- Splash Screen

### Splash Screen
<img src="img/splash.jpeg" width="250" height="" />

The first screen is a loading screen with the HealthyCheck logo

### Scanned products list
<img src="img/product_list.jpeg" width="250" height="" />

You can view all your scanned products in the list

### Detailed view of a product
<img src="img/product_detail1.jpeg" width="250" height=""/> <img src="img/product_detail2.jpeg" width="250" height=""/> <img src="img/product_detail3.jpeg" width="250" height=""/>

You can view the detail of a product by clicking on it in the list
This view shows the name of the product, the ingredients and the quantity of saturated fat, salt and sugar.

### Scanner
<img src="img/scanner.jpeg" width="250" height="" />

You can scan products by clicking on the scan button

### Animations
There are animations between two views

## Warning
The application is not a nutrionist. It can make errors so keep a critical eye.
The data showed belongs to OpenFoodFacts' API, the images or the names can be incorrect

## Used librairies
[Gson](https://github.com/google/gson)

[Retrofit](https://github.com/square/retrofit)

[RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)

[Zxing](https://github.com/zxing/zxing)

[Picasso](https://square.github.io/picasso/)

## Inspirations

[Yuka](https://yuka.io/)

[OpenFoodFacts](https://github.com/openfoodfacts/openfoodfacts-androidapp)
