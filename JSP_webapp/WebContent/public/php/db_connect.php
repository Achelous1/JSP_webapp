<?
$servername = "localhost/xe";
$username = "scott";
$password = "tiger";

// Create connection
$conn = new oci_connect($username, $password, $servername);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
echo "<script>console.log('Connected successfully');</script>";
?>