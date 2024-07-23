SELECT 
	c.FirstName || ' ' || c.LastName AS Customer,
	a.title AS Album,
	/*
	 * See the joins below to see how we gained access to the values for this third column. Once
	 * we have access to the tracks purchased count and total tracks in albums, we can calculate
	 * the percentage of tracks purchased per album and use the round function to format
	 * the result to meet the coding challenge formatting requirement
	 */
	ROUND(count(t.TrackId) * 100.0 / TotalTracksForAlbums.TotalTracks, 2) AS PercentagePurchased
FROM Customer c 
/*
 * Because there is no way to meaningfully connect the Album and Customer tables directly to
 * get the the Customer names and Album titles they made purchases from, we need to join all
 * the relevant tables in-bewteen them in order to facilitate the query.
 */
JOIN Invoice i ON c.CustomerId = i.CustomerId 
JOIN InvoiceLine il ON i.InvoiceId = il.InvoiceId 
JOIN Track t ON il.TrackId = t.TrackId 
JOIN Album a ON t.AlbumId = a.AlbumId 
/*
 * We have one more problem: we can get the total number of tracks purchased from each album,
 * but we don't have easy access to the total number of albums that we need in order to calculate
 * the percentage of tracks purchased. To get that missing piece of information we can use a
 * sub query to get the total track count of each album and join the result set to gain
 * access to that total track value
 */
JOIN 
	(
		SELECT count(t.trackId) AS TotalTracks, a.Title 
		FROM Track t 
		JOIN Album a ON t.AlbumId = a.AlbumId 
		GROUP BY a.Title
	) AS TotalTracksForAlbums
	ON a.Title = TotalTracksForAlbums.Title
/*
 * remember to group by both customer and album: the percentage of tracks purchased from each
 * album needs to be calculated. Also don't forget to order the result set
 */
GROUP BY Customer, Album
ORDER BY Customer asc
;

-- query to get first column of information (first and last name in Customer column)
SELECT c.FirstName || ' ' || c.LastName AS Customer FROM Customer c ;

-- query to get Album title in a column named "Album"
SELECT a.title AS Album FROM Album a ;

-- query to get total number of tracks in albums
SELECT count(t.trackId) AS TotalTracks, a.Title 
FROM Track t 
JOIN Album a ON t.AlbumId = a.AlbumId 
GROUP BY a.Title 

