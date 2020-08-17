<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Booking Summary</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
    <div class="row py-5 p-4 bg-white rounded shadow-sm">
              
        <div class="col-lg-6">
          <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Booking summary </div>
          <div class="p-4">
            <p class="font-italic mb-4">Driver And Additonal Details</p>
            <ul class="list-unstyled mb-4">
              <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Driver Name </strong><strong id="total">
                <% 
	                String name=session.getAttribute("driverNick").toString();
	                out.println(name);
                %>
              </strong></li>
              <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Contact</strong><strong>
              <%
            		  String phone=session.getAttribute("driverPhn").toString();
              			out.println(phone);
              %></strong></li>
              
              <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Estimted Max Price</strong>
                <h5 class="font-weight-bold">
                <% 
	                String bill=session.getAttribute("totprice").toString();
	                out.println(bill);
                %>
                </h5>
              </li>

            </ul><a href="index.html" class="btn btn-dark rounded-pill py-2 btn-block">Place The Ride</a>
          </div>
        </div>
      </div>
 
      <script src="ord.js"></script>
</body>
</html>


