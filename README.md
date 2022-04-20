# DataBindingExample

A Simple App Example using DataBinding: Binding Adapters, LiveData-MutableLiveData.

The app shows a card with informatión of a product like title, price, description, stock and a buy button. When we click the button, stock decrease, when is > 25 the app considers a high stock and draws one green icon:
<div align="center">
    <img src="./img/high_stock.jpg" width="200" alt="Stock High"/>
</div>
When stock is > 10 that icon is yellow:
<div align="center">
    <img src="./img/normal_stock.jpg" width="200" alt="Stock High"/>
</div>
If stock is < 10 the icon is red, finally if stock = 0 the title and the price are crossed out by a line:
<div align="center">
    <img src="./img/low_stock.jpg" width="200" alt="Stock High"/>
</div>

This concept may be implemented in an app with petitions to an API REST and RecyclerViews
