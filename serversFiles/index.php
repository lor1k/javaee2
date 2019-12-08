<?php
//echo "Server is on!\n";

require 'config.php';
require 'db.php';
require 'model.php';
require 'auth.php';

header('Content-type: application/json');
header('Access-Control-Allow-Origin: *');
header(
    'Access-Control-Allow-Methods: GET, PUT, POST, DELETE, OPTIONS'
);
header(
    'Access-Control-Allow-Headers: Origin, Content-Type, X-Auth-Token, Authorization');

$action = $_REQUEST['action'];
$input = json_decode(file_get_contents('php://input'), true);
//$input = array("username" => $_REQUEST["username"], "passwd" => $_REQUEST["passwd"]);
if($action == 'get_types_list'){
    if(Auth::checkToken($_REQUEST)){
        $data = Model::getTypesList();
    } else {
        $data = ['err' => 'permission denied'];
    }

}elseif($action == 'get_type' && isset($_REQUEST['type_id'])){
    if(Auth::checkToken($_REQUEST)){
        $type = Model::getType($_REQUEST['type_id']);    
        if(count($type)>0){
            $data = $type[0];
        }else{
            $data = array('err' => 'no types found');
        }
    } else {
        $data = ['err' => 'permission denied'];
    }



}elseif($action == 'add_type' && $_POST){
    if(Auth::checkToken($_REQUEST)){
        $input = json_decode(file_get_contents('php://input'), true);
        $res = Model::addType($input);
        $data = [
            $res
        ];   
    } else {
        $data = ['err' => 'permission denied'];
    }
    
}elseif($action == 'edit_type' && $_POST){
    if(Auth::checkToken($_REQUEST)){
        $input = json_decode(file_get_contents('php://input'), true);
        $res = Model::editType($input);
        $data = [
            $res
        ];     
    } else {
        $data = ['err' => 'permission denied'];
    }
}elseif($action == 'remove_type' && $_POST){
    if(Auth::checkToken($_REQUEST)){
       
        $res = Model::removeType($input);
        $data = [
            $res
        ];    
    } else {
        $data = ['err' => 'permission denied'];
    }   
}elseif($action == 'login'){
    $token = Auth::getUserToken($input);
    //echo json_encode($input);
    $data = [
        "token" => $token
    ];
}elseif($action == 'base'){
    $data = Model::getTypesList();
}elseif($action == 'fact'){

        $input = json_decode(file_get_contents('php://input'), true);
        $res = fact($input['num']); 
        $data = [
            $res
        ];     

} else {
    echo $action;
    echo json_encode($_POST);
    $data = array('err' => 'no action was sent');
}
echo json_encode($data);

function fact($num){
    if($num == 0){
        return 1;
    }else{
        return $num * fact($num-1);
    }
}
?>