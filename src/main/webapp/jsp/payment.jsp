<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<center>
	<h1>Donation Page</h1>
	<form action="OrderCreation" method="post">

     <h3>Enter Your Name</h3>
     <input name="name" type="text">


     <h3>Enter Amount</h3>
     <input name="amount" type="text"></br>

      <br><button id="rzp-button1">Pay with Razorpay</button>
      </center>
	</form>
<script>
    var xhttp = new XMLHttpRequest();
    var RazorpayOrderId;

    function CreateOrderId() {
        xhttp.open("GET", "http://localhost:8080/PaymentModule/OrderCreation", true); // Use true for async
        xhttp.onreadystatechange = function() {
            if (this.readyState === 4 && this.status === 200) {
                RazorpayOrderId = this.responseText;
                OpenCheckout();
            }
        };
        xhttp.send();
    }
</script>

<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script>
function OpenCheckout{

var options = {
    "key": "rzp_test_sTqCcxyqEhqktK", // Enter the Key ID generated from the Dashboard
    "amount": "9000", // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
    "currency": "INR",
    "name": "Acme Corp",
    "description": "Test Transaction",
    "image": "https://example.com/your_logo",
    "order_id": RazorpayOrderId, //This is a sample Order ID. Pass the `id` obtained in the response of Step 1

	 "handler": function (response){
        alert(response.razorpay_payment_id);
        alert(response.razorpay_order_id);
        alert(response.razorpay_signature)
    },
    "prefill": {
        "name": "Gaurav Kumar",
        "email": "gaurav.kumar@example.com",
        "contact": "9000090000"
    },
    "notes": {
        "address": "Razorpay Corporate Office"
    },
    "theme": {
        "color": "#3399cc"
    }
    rzp1.open();
};
var rzp1 = new Razorpay(options);
rzp1.on('payment.failed', function (response){
        alert(response.error.code);
        alert(response.error.description);
        alert(response.error.source);
        alert(response.error.step);
        alert(response.error.reason);
        alert(response.error.metadata.order_id);
        alert(response.error.metadata.payment_id);
});
document.getElementById('rzp-button1').onclick = function(e){

    CreateOrderId();
    e.preventDefault();
}

</script>

</body>
</html>