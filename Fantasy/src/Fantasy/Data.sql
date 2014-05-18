	
INSERT INTO BAND (BAND_NAME, START_DATE, END_DATE) VALUES('SOJA', '1997-01-01', NULL);
INSERT INTO BAND (BAND_NAME, START_DATE, END_DATE) VALUES('Three Legged Fox', '2006-04-10', NULL);
INSERT INTO BAND (BAND_NAME, START_DATE, END_DATE) VALUES('Rebelution','2004-06-03', NULL);
INSERT INTO BAND (BAND_NAME, START_DATE, END_DATE) VALUES('The Green', '2009-01-01', NULL);

INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('SOJA', '1997-01-01', 'Jacob', 'Hemphill', 'Vocals', '1997-01-01', NULL);
INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('SOJA', '1997-01-01', 'Bob', 'Jefferson', 'Bass', '1997-01-01', NULL);
INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('SOJA', '1997-01-01', 'Patrick', 'OShea', 'KeyBoards', '1997-01-01', NULL);
INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('SOJA', '1997-01-01', 'Ryan', 'Berty', 'Drums', '1997-01-01', NULL);

INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('Three Legged Fox', '2006-04-10', 'Kyle', 'Wareham', 'Vocals', '2006-04-10', NULL);
INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('Three Legged Fox', '2006-04-10', 'Kory', 'Kochersperger', 'Drums', '2006-04-10', NULL);
INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('Three Legged Fox', '2006-04-10', 'Mark', 'Carson', 'Bass', '2006-04-10', NULL);
INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('Three Legged Fox', '2006-04-10', 'Jon', 'Duxbury', 'KeyBoards', '2006-04-10', NULL);
INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('Three Legged Fox', '2006-04-10', 'Chris', 'Duddy', 'Guitar', '2006-04-10', NULL);
INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('Three Legged Fox', '2006-04-10', 'Mike', 'Brody', 'Guitar', '2006-04-10', '2010-12-12');

INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('Rebelution', '2004-06-03', 'Eric', 'Rachmany', 'Vocals', '2004-06-03', NULL);
INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('Rebelution', '2004-06-03', 'Marley', 'Williams', 'Bass', '2004-06-03', NULL);
INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('Rebelution', '2004-06-03','Rory', 'Carey', 'KeyBoards', '2004-06-03', NULL);
INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('Rebelution', '2004-06-03','Wesley', 'Finley', 'Drums', '2004-06-03', NULL);

INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('The Green', '2009-01-01', 'Caleb', 'Keolanui', 'Vocals', '2009-01-01', NULL);
INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('The Green', '2009-01-01', 'Ikaika', 'Antone', 'KeyBoards', '2009-01-01', NULL);
INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('The Green', '2009-01-01', 'JP', 'Kennedy', 'Guitar', '2009-01-01', NULL);
INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('The Green', '2009-01-01', 'Zion', 'Thompson', 'Guitar', '2009-01-01', NULL);
INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('The Green', '2009-01-01', 'Brad', 'Watanabe', 'Bass', '2009-01-01', NULL);
INSERT INTO BAND_MEMBER (BAND_NAME, START_DATE, FNAME, LNAME, POSITION_IN_BAND, BAND_START_DATE, END_DATE) VALUES('The Green', '2009-01-01', 'Jordan', 'Espinoza', 'Drums', '2009-01-01', NULL);


INSERT INTO ALBUM (ALBUM_NAME, BAND_NAME, START_DATE, RELEASE_YEAR, RECORD_LABEL) VALUES('Soldiers of Jah Army', 'SOJA', '1997-01-01', '2000-01-01', NULL);
INSERT INTO ALBUM (ALBUM_NAME, BAND_NAME, START_DATE, RELEASE_YEAR, RECORD_LABEL) VALUES('Peace in a Time of War', 'SOJA', '1997-01-01', '2003-01-01', NULL);
INSERT INTO ALBUM (ALBUM_NAME, BAND_NAME, START_DATE, RELEASE_YEAR, RECORD_LABEL) VALUES('Get Wiser', 'SOJA', '1997-01-01', '2006-01-01', NULL);

INSERT INTO ALBUM (ALBUM_NAME, BAND_NAME, START_DATE, RELEASE_YEAR, RECORD_LABEL) VALUES('Ideas', 'Three Legged Fox', '2006-04-10', '2007-01-01', NULL);
INSERT INTO ALBUM (ALBUM_NAME, BAND_NAME, START_DATE, RELEASE_YEAR, RECORD_LABEL) VALUES('Not As Far', 'Three Legged Fox', '2006-04-10', '2009-04-01', NULL);
INSERT INTO ALBUM (ALBUM_NAME, BAND_NAME, START_DATE, RELEASE_YEAR, RECORD_LABEL) VALUES('Always Anyway', 'Three Legged Fox', '2006-04-10', '2011-08-01', NULL);
INSERT INTO ALBUM (ALBUM_NAME, BAND_NAME, START_DATE, RELEASE_YEAR, RECORD_LABEL) VALUES('We Are Electric', 'Three Legged Fox', '2006-04-10', '2014-01-01', NULL);

INSERT INTO ALBUM (ALBUM_NAME, BAND_NAME, START_DATE, RELEASE_YEAR, RECORD_LABEL) VALUES('Courage to Grow', 'Rebelution', '2004-06-03', '2007-01-01', NULL);
INSERT INTO ALBUM (ALBUM_NAME, BAND_NAME, START_DATE, RELEASE_YEAR, RECORD_LABEL) VALUES('Bright Side of Life', 'Rebelution', '2004-06-03', '2009-01-01', NULL);

INSERT INTO ALBUM (ALBUM_NAME, BAND_NAME, START_DATE, RELEASE_YEAR, RECORD_LABEL) VALUES('The Green', 'The Green', '2009-01-01', '2010-01-01', NULL);
INSERT INTO ALBUM (ALBUM_NAME, BAND_NAME, START_DATE, RELEASE_YEAR, RECORD_LABEL) VALUES('Ways & Means', 'The Green', '2009-01-01', '2011-01-01', NULL);

INSERT INTO SONG (BAND_NAME, SONG_NAME, ALBUM_NAME, TRACK_NUM) VALUES('SOJA','Rust','Soldiers of Jah Army',1);
INSERT INTO SONG (BAND_NAME, SONG_NAME, ALBUM_NAME, TRACK_NUM) VALUES('SOJA','Open Says Me','Soldiers of Jah Army',2);
INSERT INTO SONG (BAND_NAME, SONG_NAME, ALBUM_NAME, TRACK_NUM) VALUES('SOJA','Open the door', 'Soldiers of Jah Army',3);
INSERT INTO SONG (BAND_NAME, SONG_NAME, ALBUM_NAME, TRACK_NUM) VALUES('SOJA','Freebee','Soldiers of Jah Army',4);


INSERT INTO VENUE (VENUE_NAME, STREET_ADDRESS, CITY, US_STATE) VALUES('Recher Theatre','512 York Road','Baltimore','MD');
INSERT INTO VENUE (VENUE_NAME, STREET_ADDRESS, CITY, US_STATE) VALUES('Electric Factory','421 N 7th St','Philadelphia','PA');
INSERT INTO VENUE (VENUE_NAME, STREET_ADDRESS, CITY, US_STATE) VALUES('California Roots','2004 Fairground Road','Monterey','CA');
INSERT INTO VENUE (VENUE_NAME, STREET_ADDRESS, CITY, US_STATE) VALUES('The Note','142 East Market Street','West Chester','PA');

--INSERT INTO EVENT (VENUE_ID, EVENT_DATE)

--INSERT INTO PERFORMANCE (BAND_NAME, START_DATE, VENUE_ID, EVENT_DATE, DURATION)

--INSERT INTO SET_LIST (BAND_NAME, EVENT_DATE, VENUE_ID, SONG_NAME, WRITTEN_BY)

INSERT INTO FANTASY_USER (USER_NAME, FNAME, MINIT, LNAME, BIRTH_DATE) VALUES('Ahall','Alex','D','Hall',NULL);
INSERT INTO FANTASY_USER (USER_NAME, FNAME, MINIT, LNAME, BIRTH_DATE) VALUES('Bharvey','Ben','','Harvey',NULL);
INSERT INTO FANTASY_USER (USER_NAME, FNAME, MINIT, LNAME, BIRTH_DATE) VALUES('Jtitus','Jordan','','Titus',NULL);
INSERT INTO FANTASY_USER (USER_NAME, FNAME, MINIT, LNAME, BIRTH_DATE) VALUES('Mwarehime','Michael','','Warehime',NULL);

INSERT INTO FOLLOWED (USER_NAME, BAND_NAME, START_DATE) VALUES('Ahall','Three Legged Fox','2006-04-10');
INSERT INTO FOLLOWED (USER_NAME, BAND_NAME, START_DATE) VALUES('Ahall','The Green','2009-01-01');
INSERT INTO FOLLOWED (USER_NAME, BAND_NAME, START_DATE) VALUES('Bharvey','The Green','2009-01-01');
INSERT INTO FOLLOWED (USER_NAME, BAND_NAME, START_DATE) VALUES('Jtitus','Rebelution','2004-06-03');
INSERT INTO FOLLOWED (USER_NAME, BAND_NAME, START_DATE) VALUES('Mwarehime','SOJA','1997-01-01');

--INSERT INTO ATTENDED (USER_NAME, VENUE_ID, EVENT_DATE, COMMENTS)

--INSERT INTO FANTASY_PERFORMANCE (BAND_NAME, USER_NAME, DURATION, CREATION_DATE, LAST_EDIT)

--INSERT INTO FANTASY_SETLIST (BAND_NAME, USER_NAME, FANTASY_SET_LIST_ID, SONG_NAME, ALBUM_NAME, WRITTEN_BY)