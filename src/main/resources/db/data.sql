INSERT INTO User (username,password,enabled) VALUES ('admin','$2a$04$ijI7QiRSyWqFhC76fc4mU.4bmSkNBS2WmlfIdLwlVqUnGWlBBy7Qe',true);
INSERT INTO User (username,password,enabled) VALUES ('test','$2a$04$Qx96pzwHRZnNIo7U5qwvYuTCc5UlMt1io8YtfbuCHfcNn5/oo1U4m',true);

INSERT INTO Role (user_id,role) VALUES (1,'ROLE_ADMIN');
INSERT INTO Role (user_id,role) VALUES (1,'ROLE_USER');
INSERT INTO Role (user_id,role) VALUES (2,'ROLE_USER');

INSERT INTO Post (body,created,author_id) VALUES ('Lorem 1 ipsum dolor sit amet, postea impedit rationibus at vix, vel ei ubique dictas singulis. Insolens phaedrum ea eos. Accusam repudiandae nam an. Ne nam magna putant gubergren. Sea te exerci adversarium. Te nullam option debitis mei, ad eos dicant eruditi omittantur, odio paulo theophrastus mei ad.','2015-08-04 10:57:12',1);
INSERT INTO Post (body,created,author_id) VALUES ('Lorem 2 ipsum dolor sit amet, postea impedit rationibus at vix, vel ei ubique dictas singulis. Insolens phaedrum ea eos. Accusam repudiandae nam an. Ne nam magna putant gubergren. Sea te exerci adversarium. Te nullam option debitis mei, ad eos dicant eruditi omittantur, odio paulo theophrastus mei ad.','2015-03-17 10:57:12',1);
INSERT INTO Post (body,created,author_id) VALUES ('Lorem 3 ipsum dolor sit amet, postea impedit rationibus at vix, vel ei ubique dictas singulis. Insolens phaedrum ea eos. Accusam repudiandae nam an. Ne nam magna putant gubergren. Sea te exerci adversarium. Te nullam option debitis mei, ad eos dicant eruditi omittantur, odio paulo theophrastus mei ad.','2015-01-01 10:57:12',2);
INSERT INTO Post (body,created,author_id) VALUES ('Lorem 4 ipsum dolor sit amet, postea impedit rationibus at vix, vel ei ubique dictas singulis. Insolens phaedrum ea eos. Accusam repudiandae nam an. Ne nam magna putant gubergren. Sea te exerci adversarium. Te nullam option debitis mei, ad eos dicant eruditi omittantur, odio paulo theophrastus mei ad.','2014-06-23 10:57:12',2);
INSERT INTO Post (body,created,author_id) VALUES ('Lorem 5 ipsum dolor sit amet, postea impedit rationibus at vix, vel ei ubique dictas singulis. Insolens phaedrum ea eos. Accusam repudiandae nam an. Ne nam magna putant gubergren. Sea te exerci adversarium. Te nullam option debitis mei, ad eos dicant eruditi omittantur, odio paulo theophrastus mei ad.','2013-11-09 10:57:12',2);
