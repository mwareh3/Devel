
drop table BAND_MEMBER;
drop table FANTASY_SETLIST;
drop table SONG;
drop table ALBUM;
drop table SET_LIST;
drop table PERFORMANCE;
drop table ATTENDED;
drop table EVENT;
drop table VENUE;
drop table FANTASY_PERFORMANCE;
drop table FOLLOWED;
drop table BAND;
drop table FANTASY_USER;


create table BAND
(
	BAND_NAME VARCHAR(32),
	START_DATE DATE,
        END_DATE DATE default null,
        constraint BAND_PK primary key(BAND_NAME,START_DATE)

);

create table BAND_MEMBER
(
	BAND_NAME VARCHAR(32),
        START_DATE DATE,
	FNAME VARCHAR(32),
	MINIT VARCHAR(1),
	LNAME VARCHAR(32),
	POSITION_IN_BAND VARCHAR(32), 
        BAND_START_DATE DATE,
        END_DATE DATE default null,
        
        constraint BAND_MEMBER_PK primary key (BAND_NAME,FNAME,LNAME),
        constraint BAND_MEMBER_FK foreign key (BAND_NAME,START_DATE) references BAND(BAND_NAME,START_DATE)
);

create table ALBUM
(
	ALBUM_NAME VARCHAR(32),
        BAND_NAME VARCHAR(32),
        START_DATE DATE,
        RELEASE_YEAR DATE,
        RECORD_LABEL VARCHAR(32),
        constraint ALBUM_PK primary key (ALBUM_NAME, BAND_NAME),
        constraint ALBUM_FK foreign key (BAND_NAME,START_DATE) references BAND(BAND_NAME,START_DATE)
);

create table SONG
(
	BAND_NAME VARCHAR(32),
	SONG_NAME VARCHAR(32),
	ALBUM_NAME VARCHAR(32),
	TRACK_NUM INTEGER,
        constraint SONG_PK primary key (BAND_NAME, SONG_NAME, ALBUM_NAME),
        constraint SONG_FK foreign key (ALBUM_NAME, BAND_NAME ) references ALBUM(ALBUM_NAME,BAND_NAME)
);

create table VENUE
(
	VENUE_ID INTEGER AUTO_INCREMENT,
        VENUE_NAME VARCHAR(32),
        STREET_ADDRESS VARCHAR(256),
        CITY VARCHAR(32),
        US_STATE VARCHAR(2),
        constraint VENUE_PK primary key (VENUE_ID)
);

create table EVENT
(
        VENUE_ID INTEGER,
	EVENT_DATE DATE,
        constraint EVENT_PK primary key (VENUE_ID, EVENT_DATE),
        constraint EVENT_FK foreign key (VENUE_ID) references VENUE(VENUE_ID)
);

create table PERFORMANCE
(
        BAND_NAME VARCHAR(32),
        START_DATE DATE,
        VENUE_ID INTEGER,
        EVENT_DATE DATE,
        DURATION INTEGER,
        constraint PERFORMANCE_PK primary key (BAND_NAME,VENUE_ID,EVENT_DATE),
        constraint PERFORMANCE_BAND_NAME_FK foreign key (BAND_NAME,START_DATE) references BAND(BAND_NAME,START_DATE),
        constraint PERFORMANCE_EVENT_FK foreign key (VENUE_ID,EVENT_DATE) references EVENT(VENUE_ID,EVENT_DATE)
);

create table SET_LIST
(
        BAND_NAME VARCHAR(32),
        EVENT_DATE DATE,
        VENUE_ID INTEGER,
        SONG_NAME VARCHAR(32),
        WRITTEN_BY VARCHAR(32),
        constraint SET_LIST_PK primary key (BAND_NAME,EVENT_DATE),
        constraint SET_LIST_FK foreign key (BAND_NAME,VENUE_ID,EVENT_DATE) references PERFORMANCE(BAND_NAME,VENUE_ID,EVENT_DATE)
);

create table FANTASY_USER
(
        USER_NAME VARCHAR(32),
        FNAME VARCHAR(32),
        MINIT VARCHAR(1),
        LNAME VARCHAR(32),
        BIRTH_DATE DATE,
        constraint FANTASY_USER_PK primary key (USER_NAME)
);

create table FOLLOWED
(
        USER_NAME VARCHAR(32),
        BAND_NAME VARCHAR(32),
        START_DATE DATE,
        constraint FOLLOWED_PK primary key (USER_NAME,BAND_NAME),
        constraint FOLLOWED_BAND_FK foreign key (BAND_NAME,START_DATE) references BAND(BAND_NAME,START_DATE),
        constraint FOLLOWED_FANTASY_USER_FK foreign key (USER_NAME) references FANTASY_USER(USER_NAME)
);

create table ATTENDED
(
        USER_NAME VARCHAR(32),
        VENUE_ID INTEGER,
        EVENT_DATE DATE,
        COMMENTS VARCHAR(1024),
        constraint ATTENDED_PK primary key (USER_NAME,VENUE_ID),
        constraint ATTENDED_FOLLOWED_FK foreign key (USER_NAME) references FANTASY_USER(USER_NAME),
        constraint ATTENDED_VENUE_FK foreign key (VENUE_ID,EVENT_DATE) references EVENT(VENUE_ID,EVENT_DATE)
);

create table FANTASY_PERFORMANCE
(
        BAND_NAME VARCHAR(32),
        USER_NAME VARCHAR(32),
        DURATION INTEGER,
        CREATION_DATE DATE,
        LAST_EDIT DATE,
        constraint FANTASY_PERFORMANCE_PK primary key (BAND_NAME, USER_NAME),
        constraint FANTASY_PERFORMANCE_FK foreign key (USER_NAME,BAND_NAME) references FOLLOWED(USER_NAME,BAND_NAME)
);

create table FANTASY_SETLIST
(
        BAND_NAME VARCHAR(32),
        USER_NAME VARCHAR(32),
        FANTASY_SET_LIST_ID INTEGER,
        SONG_NAME VARCHAR(32),
        ALBUM_NAME VARCHAR(32),
        WRITTEN_BY VARCHAR(32),
        constraint FANTASY_SETLIST_PK primary key (BAND_NAME,USER_NAME),
        constraint FANTASY_SETLIST_USER_FK foreign key (USER_NAME,BAND_NAME) references FOLLOWED(USER_NAME,BAND_NAME),
        constraint FANTASY_SETLIST_SONG_FK foreign key (BAND_NAME,SONG_NAME,ALBUM_NAME) references SONG(BAND_NAME, SONG_NAME, ALBUM_NAME)
);
