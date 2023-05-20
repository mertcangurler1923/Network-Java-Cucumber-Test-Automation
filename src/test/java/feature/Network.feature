Feature: Network Test

  Scenario: Adding the discounted product to the cart and deleting it.

      Given “https://www.network.com.tr/” access.
      When The network url is checked.
      And Search components “jacket” are printed and searched.
      And Scrolling as much as the show more button on the product listing page.
      And It is checked that the 2nd page is passed (url changes).
      And You hover over the first discounted product on the product list page, a random size selection is made.
      And Hover the Go to Cart button that opens in the lower right corner.
      And It is checked that the size and price information of the product is correct in the basket.
      And It is checked that the old price of the product added to the cart is greater than the discounted price.
      And Continue button is clicked.
      And Filling in the user information from csv format (E-mail - by reading the password from the csv file is necessary.)
      And Check that the login button has arrived.
      And Click the network logo.
      And By clicking on the bag logo on the main page, the right side of the Sepetim building opens.
      Then It is checked that the basket is empty by removing the product from the basket.
