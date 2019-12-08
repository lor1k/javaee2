<?php

class Auth{
    public static function getUserToken($user){
        $db = new DB();

        // echo $user['username'];
        // echo $user['passwd'];
        // echo json_encode($out);
        // echo ' - ';
        // echo json_encode($user);
        // echo " SQL: ";
        // echo  "select id from user where username='".$user['username']."' and passwd='".$user['passwd']."'";
        $res = $db->getArrayFromQuery(
            "select id from user where username='".$user['username']."' and passwd='".$user['passwd']."'"
        );
        //echo count($res);

        if(count($res) > 0){
            $id = $res[0]['id'];
            $token = bin2hex(random_bytes(64));
            $res2 = $db->runQuery(
                "update user set token='$token' where id = $id"
            );
            if($res2){
                return $token;
            }
        }
        return null;
    }

    public static function checkToken($user){
        $db = new DB();
        $res = $db->getArrayFromQuery(
            "select id from user where token='".$user['token']."'"
        );
        if(count($res)>0){
            return true;
        }
        return false;
    }



}



?>