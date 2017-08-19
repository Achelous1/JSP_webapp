<?
include('db_connect.php');

$query = "select mem_id, mem_pw from members where mem_id = $_POST["user_id"] and mem_pw = $_POST["user_pw"]";
$result = oci_parse($connection, $query);
$success = oci_execute($result);

oci_free_statement($result);
oci_close($connection);
?>