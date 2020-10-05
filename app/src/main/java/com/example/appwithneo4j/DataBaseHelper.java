package com.example.appwithneo4j;


import android.content.ContentValues;
import android.database.DatabaseUtils;
import android.util.Log;

import org.neo4j.driver.AccessMode;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import static org.neo4j.driver.SessionConfig.builder;
import static org.neo4j.driver.Values.parameters;
import static android.content.ContentValues.TAG;


public class DataBaseHelper {

    public DataBaseHelper() {
    }

    public boolean AddPerson(PersonModel personModel){

        ContentValues cv =new ContentValues();
        //cv.put(COLUMN_FIRSTNAME, personModel.getName());

        long insert =-1 ;
        String username = "neo4j";
        String password = "password";
        Driver driver = null;

        driver = GraphDatabase.driver("bolt://192.168.1.3:7687", AuthTokens.basic(username, password));
        Session session = driver.session( builder().withDefaultAccessMode( AccessMode.READ ).build() );
        Log.i(TAG, "####################################start run function");

        Result result =session.run( "WITH date('1998-12-01') - duration('P71D') AS my_date\n" +
                "MATCH (item:LINEITEM)\n" +
                "WHERE date(item.L_SHIPDATE) <= date(my_date)\n" +
                "RETURN item.L_RETURNFLAG,item.L_LINESTATUS,sum(tofloat(item.L_QUANTITY)) AS sum_qty,\n" +
                "sum(item.L_EXTENDEDPRICE) AS sum_base_price, sum(tofloat(item.L_EXTENDEDPRICE)*(1-tofloat(item.L_DISCOUNT))) AS sum_disc_price,\n" +
                "sum(tofloat(item.L_EXTENDEDPRICE)*(1-tofloat(item.L_DISCOUNT))*(1+tofloat(item.L_TAX))) AS sum_charge,\n" +
                "avg(tofloat(item.L_QUANTITY)) AS avg_qty, avg(item.L_EXTENDEDPRICE) AS avg_price, \n" +
                "avg(item.L_DISCOUNT) AS avg_disc, COUNT(*) AS count_order\n" +
                "ORDER BY item.L_RETURNFLAG, item.L_LINESTATUS", parameters( ) );


        Log.i(TAG, "####################################stop run function");
        //Log.v("cur", result.);


        return true;

//        if(insert == -1){
//            return false;
//        }
//        else{
//
//            return true;
//        }
    }
}
