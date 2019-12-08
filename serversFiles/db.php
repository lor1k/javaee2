<?php

class DB{
    private $link;
    public $err;
    public function connect(){
        $this->link = new \mysqli(
            \Config::$server, \Config::$user, \Config::$password, \Config::$db
        );
        if(!$this->link){
            return false;
        }
        $this->runQuery("SET NAME 'utf-8'");
        return true;
    }

    public function disconect(){
        $this->link->close();
        unset($this->link);
    }
    public function runQuery($sql){
        if(!$this->link){
            $this->connect();
        }
        $res = $this->link->query($sql);
        //echo $res;
        if(!$res){
            $this->err = $this->link->error;
        }
        return $res;
    }
    public function getArrayFromQuery($sql){
        $res_arr = array();
        $rs = $this->runQuery($sql);
        while($row = mysqli_fetch_assoc($rs)){
            $res_arr[] = $row;
        }
        return $res_arr;
    }
}

?>
