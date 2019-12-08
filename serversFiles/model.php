<?php
class Model{
    public static function getTypesList()
    {
        $db = new DB();
        return 
            $db->getArrayFromQuery(
                "SELECT * FROM GameType order by id"
            );
    }
    public static function getType($id){
        $db = new DB();
        return $db->getArrayFromQuery(
            "SELECT * FROM GameType where id=$id"
        );
    }

    public static function addType($type){
        $db = new DB();
        return $db->runQuery(
            "insert into GameType(typeName, released, oWorld, isFree) values
            ('".$type['typeName']."', ".$type['released'].", ".$type['oWorld'].
            ", ". $type['isFree'].")"); 
    }
    public static function editType($type){
        $db = new DB();
        return $db->runQuery(
            "update GameType set typeName = '".$type['typeName'].
            "', released = ".$type['released'].
            ", oWorld = ".$type['oWorld'].
            ", isFree = ".$type['isFree'].
            " where id = " . $type["id"]);
    }
    public static function removeType($type){
        $db = new DB();
        return $db->runQuery(
            "delete from GameType 
            where id = ". $type['id']);
    }
}
?>