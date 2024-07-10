/*
 * To limit the number of potential records in your result set you can use the
 * limit keyword and indicate the max number of records you want returned in your result
 * set
 */
select * from Customer c order by Company asc limit 2 ;

/*
 * if you want your result set to start on a record other than the first option 
 * that would normally be returned you can use the offset keyword to indicate how many rows
 * beyond the first you want your result set to start with
 */
select * from Customer c limit 2 offset 1;