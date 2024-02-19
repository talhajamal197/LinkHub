INSERT INTO user_profiles (user_id, name, age) VALUES (1, 'John 	Doe', 30), (2, 'Jane Smith', 25), (3, 'Alice Johnson', 28);

INSERT INTO profile_visits(visit_id, visitor_id, profile_id, 	visit_timestamp) VALUES (1, 1, 2, '2024-02-18 08:30:00'), (2, 1, 3, 	'2024-02-18 09:15:00'), (3, 2, 1, '2024-02-18 10:00:00');

INSERT INTO user_likes (like_id, liker_id, liked_profile_id, 	like_timestamp) VALUES (1, 1, 3, '2024-02-18 09:00:00'), (2, 2, 1,     	'2024-02-18 11:30:00');