INSERT INTO `tb_paper_catalog` (`id`, `name`, `type`, `section_code`, `qr_code`, `parent_id`, `level`, `create_date`, `create_by`, `update_date`, `update_by`, `remarks`, `sort`, `del_flag`)
VALUES
  /*全真考场*/
  ('101', '全真考场101', 1, 1, NULL, '0', 1, '2017-07-11 09:33:50', '1', '2017-07-11 09:33:55', '1', '1', 1, 0);


INSERT INTO `tb_paper` (`id`, `catalog_id`, `qr_code`, `name`, `content_type`, `code`, `img`, `question_num`, `create_date`, `create_by`, `update_date`, `update_by`, `remarks`, `sort`, `del_flag`)
VALUES
  /*全真考场*/
  ('101', '101', NULL , '全真考场101试卷1', 0, '1', 'http://res.xhiw.com.cn/4c8a4151719c444da98bc07a27991bcb.png', NULL, '2017-07-11 09:35:19', '1', '2017-07-21 16:10:31', '1', '1', 0, 0);



INSERT INTO `tb_paper_structure` (`id`, `paper_id`, `name`, `content_type`, `alias`, `parent_id`, `parent_ids`, `level`, `is_leaf`, `create_date`, `create_by`, `update_date`, `update_by`, `remarks`, `sort`, `del_flag`)
VALUES
  ('101', '101', 'Listening Comprehension', 1, '听力', '0', '0', 1, 0, '2017-07-11 16:10:27', '1', '2017-07-11 16:10:31', '1', '1', 0, 0),
    ('1011', '101', 'Section A', 1, '短篇新闻', '101', '0,101', 2, 0, '2017-07-11 16:10:27', '1', '2017-07-11 16:10:31', '1', '1', 0, 0),
    ('1012', '101', 'Section B', 1, '长对话', '101', '0,101', 2, 0, '2017-07-11 16:10:27', '1', '2017-07-11 16:10:31', '1', '1', 0, 0),
      ('10121', '101', 'Conversation One', 1, 'Conversation One', '1012', '0,101,1012', 3, 1, '2017-07-11 16:10:27', '1', '2017-07-11 16:10:31', '1', '1', 0, 0),
      ('10122', '101', 'Conversation Two', 1, 'Conversation Two', '1012', '0,101,1012', 3, 1, '2017-07-11 16:10:27', '1', '2017-07-11 16:10:31', '1', '1', 0, 0),
    ('1013', '101', 'Section C', 1, '新闻听力', '101', '0,101', 2, 0, '2017-07-11 16:10:27', '1', '2017-07-11 16:10:31', '1', '1', 0, 0),
      ('10131', '101', 'Passage One', 1, 'Passage One', '1013', '0,101,1013', 3, 1, '2017-07-11 16:10:27', '1', '2017-07-11 16:10:31', '1', '1', 0, 0),
      ('10132', '101', 'Passage Two', 1, 'Passage Two', '1013', '0,101,1013', 3, 1, '2017-07-11 16:10:27', '1', '2017-07-11 16:10:31', '1', '1', 0, 0),
      ('10133', '101', 'Passage Three', 1, 'Passage Three', '1013', '0,101,1013', 3, 1, '2017-07-11 16:10:27', '1', '2017-07-11 16:10:31', '1', '1', 0, 0),

  ('102', '101', 'Reading Comprehension', 2, '阅读', '0', '0', 1, 0, '2017-07-11 16:10:27', '1', '2017-07-11 16:10:31', '1', '1', 0, 0),
    ('1021', '101', 'Selection A', 2, '篇章词汇', '102', '0,102', 2, 1, '2017-07-11 16:10:27', '1', '2017-07-11 16:10:31', '1', '1', 0, 0),
    ('1022', '101', 'Selection B', 2, '长篇信息匹配', '102', '0,102', 2, 1, '2017-07-11 16:10:27', '1', '2017-07-11 16:10:31', '1', '1', 0, 0),
    ('1023', '101', 'Selection C', 2, '篇章阅读', '102', '0,102', 2, 0, '2017-07-11 16:10:27', '1', '2017-07-11 16:10:31', '1', '1', 0, 0),
      ('10231', '101', 'Passage One', 2, '篇章阅读', '1023', '0,102,1023', 3, 1, '2017-07-11 16:10:27', '1', '2017-07-11 16:10:31', '1', '1', 0, 0),
      ('10231', '101', 'Passage Two', 2, '篇章阅读', '1023', '0,102,1023', 3, 1, '2017-07-11 16:10:27', '1', '2017-07-11 16:10:31', '1', '1', 0, 0),

  ('103', '101', 'Translation', 3, '翻译', '0', '0', 1, 1, '2017-07-11 16:10:27', '1', '2017-07-11 16:10:31', '1', '1', 0, 0),
  ('104', '101', 'Writing', 4, '写作', '0', '0', 1, 1, '2017-07-11 16:10:27', '1', '2017-07-11 16:10:31', '1', '1', 0, 0);


/*Data for the table `tb_paper_question` */

INSERT INTO `tb_paper_question` (`id`, `paper_id`, `structure_id`, `question_id`, `create_date`, `create_by`, `update_date`, `update_by`, `remarks`, `sort`, `del_flag`)
VALUES
  ('1001', '101', '1011', '1001', '2017-07-11 16:20:24', '6', '2017-07-11 16:20:27', '1', '1', 1, 0),
  ('1002', '101', '1011', '1002', '2017-07-11 16:20:24', '6', '2017-07-11 16:20:27', '1', '1', 2, 0),
  ('1003', '101', '1011', '1003', '2017-07-11 16:20:24', '6', '2017-07-11 16:20:27', '1', '1', 3, 0),

  ('1004', '101', '10121', '1004', '2017-07-11 16:20:24', '6', '2017-07-11 16:20:27', '1', '1', 3, 0),
  ('1005', '101', '10122', '1005', '2017-07-11 16:20:24', '6', '2017-07-11 16:20:27', '1', '1', 3, 0),

  ('1006', '101', '10131', '1006', '2017-07-11 16:20:24', '6', '2017-07-11 16:20:27', '1', '1', 3, 0),
  ('1007', '101', '10132', '1007', '2017-07-11 16:20:24', '6', '2017-07-11 16:20:27', '1', '1', 3, 0),
  ('1008', '101', '10133', '1008', '2017-07-11 16:20:24', '6', '2017-07-11 16:20:27', '1', '1', 3, 0),

  ('1009', '101', '1021', '1009', '2017-07-11 16:20:24', '6', '2017-07-11 16:20:27', '1', '1', 3, 0),
  ('1010', '101', '1022', '1010', '2017-07-11 16:20:24', '6', '2017-07-11 16:20:27', '1', '1', 3, 0),
  ('1011', '101', '10231', '1011', '2017-07-11 16:20:24', '6', '2017-07-11 16:20:27', '1', '1', 3, 0),
  ('1012', '101', '10232', '1012', '2017-07-11 16:20:24', '6', '2017-07-11 16:20:27', '1', '1', 3, 0)
;


/*Data for the table `tb_question` 题目类型(1.听力 2.阅读 3.翻译 4.写作)*/

INSERT INTO `tb_question` (`id`, `name`, `content`, `type`, `has_item`, `question_num`, `section_code`, `analysis`, `create_date`, `create_by`, `update_date`, `update_by`, `remarks`, `del_flag`)
VALUES

/*----------- 听力开始-------------------*/
  /* Section A 短篇新闻*/
  ('1001', 'Question 1 and 2 will be based on the following news item.', '', 1, 1, 2, 1, '解析1001', '2017-07-11 16:20:03', '1', '2017-07-11 16:20:08', '1', '1', 0),
  ('1002', 'Question 3 and 4 will be based on the following news item.', '', 1, 1, 2, 1, '解析1002', '2017-07-13 09:47:33', '1', '2017-07-13 09:47:37', '1', '1', 0),
  ('1003', 'Question 5 and 6 will be based on the following news item.', '', 1, 1, 2, 1, '解析1003', '2017-07-13 09:47:33', '1', '2017-07-13 09:47:37', '1', '1', 0),
  /* Section B 长对话 Conversation One */
  ('1004', 'Question 8 and 11 will be based on the following news item.', '', 1, 1, 4, 1, '解析1004', '2017-07-11 16:20:03', '1', '2017-07-11 16:20:08', '1', '1', 0),
  /* Section B 长对话 Conversation Two */
  ('1005', 'Question 12 and 15 will be based on the following news item.', '', 1, 1, 4, 1, '解析1005', '2017-07-13 09:47:33', '1', '2017-07-13 09:47:37', '1', '1', 0),
  /* Section C 长对话 Passage One */
  ('1006', 'Question 16 and 18 will be based on the following news item.', '', 1, 1, 3, 1, '解析1006', '2017-07-13 09:47:33', '1', '2017-07-13 09:47:37', '1', '1', 0),
  /* Section C 长对话 Passage Two */
  ('1007', 'Question 19 and 22 will be based on the following news item.', '', 1, 1, 4, 1, '解析1007', '2017-07-13 09:47:33', '1', '2017-07-13 09:47:37', '1', '1', 0),
  /* Section C 长对话 Passage Three */
  ('1008', 'Question 23 and 25 will be based on the following news item.', '', 1, 1, 3, 1, '解析1008', '2017-07-13 09:47:33', '1', '2017-07-13 09:47:37', '1', '1', 0),
/*----------- 听力结束-------------------*/
/*----------- 阅读开始-------------------*/
  /*Selection A*/
  ('1009', '', '<p>vcnc(26)g</p><p>vc(27)ncg</p><p>vcncg</p><p>vcncg</p>', 2,  1, 2, 1, '解析1009', '2017-07-11 16:20:03', '1', '2017-07-11 16:20:08', '1', '1', 0),

  /*Selection B*/
  ('1010', '', '<p>A.111111111111111111111</p><p>B.2222222222222222222</p>', 2,  1, 2, 1, '解析1010', '2017-07-11 16:20:03', '1', '2017-07-11 16:20:08', '1', '1', 0),

  /*Selection C Passage One*/
  ('1011', '', '<p>1011 celebration held for the US military history</p><p>celebration held for the US military history</p><p>celebration held for the US military history</p>', 2,  1, 2, 1, '解析1010', '2017-07-11 16:20:03', '1', '2017-07-11 16:20:08', '1', '1', 0),

  /*Selection C Passage Two*/
  ('1012', '', '<p>1012 celebration held for the US military history</p><p>celebration held for the US military history</p><p>celebration held for the US military history</p>', 2,  1, 2, 1, '解析1010', '2017-07-11 16:20:03', '1', '2017-07-11 16:20:08', '1', '1', 0),


/*----------- 阅读结束-------------------*/


  ('1001', 'Question 1 and 2 will be based on the following news item.', '', 1, 1, 2, 1, '解析1001', '2017-07-11 16:20:03', '1', '2017-07-11 16:20:08', '1', '1', 0)
;

INSERT INTO `tb_question_reading` (`id`, `question_id`, `translation`)
VALUES
  (replace(uuid(),'-',''), '1009', '篇章阅读,李梅梅1009'),
  (replace(uuid(),'-',''), '1010', '篇章阅读,李梅梅 1010'),
  (replace(uuid(),'-',''), '1011', '篇章阅读,李梅梅 1011'),
  (replace(uuid(),'-',''), '1012', '篇章阅读,李梅梅 1012');

INSERT INTO `tb_question_listening` (`id`, `question_id`, `audio_url`, `tapescripts`, `translation`, `subtitle_url`)
VALUES
  ('1001', '1001', 'http://o8c5o8act.bkt.clouddn.com/DTJ161M1.MP3',
        '<p>Question 1001</p><p>1. In the middle of the 1950s, the government began requiring 2. students to attend school until the age of 16 instead of </p>',
        'which is threatening other towns south',
        'http://7xqc0j.com1.z0.glb.clouddn.com/test.lrc'),
  ('1002', '1002', 'http://o8c5o8act.bkt.clouddn.com/DTJ161M10.MP3',
         '<p>Question 1002</p><p>3.In the middle of the 1950s, the government began requiring 4. students to attend school until the age of 16 instead of </p>',
         'which is threatening other towns south',
         'http://7xqc0j.com1.z0.glb.clouddn.com/test.lrc'),
  ('1003', '1003', 'http://o8c5o8act.bkt.clouddn.com/DTJ161M5.MP3',
          '<p>Question 1003</p><p>5.In the middle of the 1950s, the government began requiring 6.students to attend school until the age of 16 instead of </p>',
          'which is threatening other towns south',
          'http://7xqc0j.com1.z0.glb.clouddn.com/test.lrc'),

  ('1004', '1004', 'http://o8c5o8act.bkt.clouddn.com/DTJ161M6.MP3',
           '<p>Question 1003</p><p>5.In the middle of the 1950s, the government began requiring 6.students to attend school until the age of 16 instead of </p>',
           'which is threatening other towns south',
           'http://7xqc0j.com1.z0.glb.clouddn.com/test.lrc'),
  ('1005', '1005', 'http://o8c5o8act.bkt.clouddn.com/DTJ161M7.MP3',
           '<p>Question 1003</p><p>5.In the middle of the 1950s, the government began requiring 6.students to attend school until the age of 16 instead of </p>',
           'which is threatening other towns south',
           'http://7xqc0j.com1.z0.glb.clouddn.com/test.lrc'),
  ('1006', '1006', 'http://o8c5o8act.bkt.clouddn.com/DTJ161M8.MP3',
           '<p>Question 1003</p><p>5.In the middle of the 1950s, the government began requiring 6.students to attend school until the age of 16 instead of </p>',
           'which is threatening other towns south',
           'http://7xqc0j.com1.z0.glb.clouddn.com/test.lrc'),
  ('1007', '1007', 'http://o8c5o8act.bkt.clouddn.com/DTJ161M9.MP3',
           '<p>Question 1003</p><p>5.In the middle of the 1950s, the government began requiring 6.students to attend school until the age of 16 instead of </p>',
           'which is threatening other towns south',
           'http://7xqc0j.com1.z0.glb.clouddn.com/test.lrc')
  ;

INSERT INTO `tb_question_item` (`id`, `question_id`, `content`, `analysis`, `create_date`, `create_by`, `update_date`, `update_by`, `remarks`, `sort`, `del_flag`)
VALUES


  ('1001', '1001', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 1, 0),
  ('1002', '1001', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 2, 0),

  ('1003', '1002', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 1, 0),
  ('1004', '1002', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 2, 0),

  ('1005', '1003', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 1, 0),
  ('1006', '1003', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 2, 0),


  ('1007', '1004', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 1, 0),
  ('1008', '1004', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 2, 0),
  ('1009', '1004', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 1, 0),
  ('1010', '1004', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 2, 0),


  ('1011', '1005', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 1, 0),
  ('1012', '1005', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 2, 0),
  ('1013', '1005', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 1, 0),
  ('1014', '1005', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 2, 0),

  ('1015', '1006', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 1, 0),
  ('1016', '1006', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 2, 0),
  ('1017', '1006', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 1, 0),

  ('1018', '1007', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 1, 0),
  ('1019', '1007', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 2, 0),
  ('1020', '1007', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 1, 0),
  ('1021', '1007', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 2, 0),

  ('1022', '1008', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 1, 0),
  ('1023', '1008', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 2, 0),
  ('1024', '1008', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 1, 0),


  ('1025', '1009', '', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 1, 0),
  ('1026', '1009', '', '解析：正确答案B', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 2, 0),


  ('1027', '1010', 'cooking benefits people in many ', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 1, 0),
  ('1028', '1010', 'abundant info mation  abouyt hone catelog ', '解析：正确答案B', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 2, 0),

  ('1029', '1011', 'what is heppening to the wallet ', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 1, 0),
  ('1030', '1011', 'how are biz  donw asdf sadfx  xvzc ', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 2, 0),

  ('1031', '1011', '1031 what is heppening to the wallet ', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 1, 0),
  ('1032', '1011', '1032 how are biz  donw asdf sadfx  xvzc ', '解析：正确答案A', '2017-07-11 16:21:23', '1', '2017-07-11 16:21:26', '1', '1', 2, 0);

INSERT INTO `tb_question_option` (`id`, `item_id`, `name`, `content`, `is_answer`, `create_date`, `create_by`, `update_date`, `update_by`, `remarks`, `sort`, `del_flag`)
VALUES

  (replace(uuid(),'-',''), '1031', 'A', NULL , 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-',''), '1031', 'B', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-',''), '1031', 'C', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-',''), '1031', 'D', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-',''), '1032', 'A', NULL , 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-',''), '1032', 'B', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-',''), '1032', 'C', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-',''), '1032', 'D', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-',''), '1029', 'A', NULL , 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-',''), '1029', 'B', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-',''), '1029', 'C', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-',''), '1029', 'D', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-',''), '1030', 'A', NULL , 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-',''), '1030', 'B', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-',''), '1030', 'C', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-',''), '1030', 'D', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-',''), '1027', 'A', NULL , 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-',''), '1027', 'B', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-',''), '1027', 'C', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-',''), '1027', 'D', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1027', 'E', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1027', 'F', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1027', 'G', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1027', 'H', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1027', 'I', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1027', 'J', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1027', 'K', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1027', 'L', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),


  (replace(uuid(),'-',''), '1028', 'A', NULL , 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-',''), '1028', 'B', NULL, 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-',''), '1028', 'C', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-',''), '1028', 'D', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1028', 'E', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1028', 'F', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1028', 'G', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1028', 'H', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1028', 'I', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1028', 'J', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1028', 'K', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1028', 'L', NULL, 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),


  ('1001', '1001', 'A', 'celebration held for the US military history', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1002', '1001', 'B', 'new celebration military history', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1003', '1001', 'C', 'military history held for the history', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1004', '1001', 'D', 'held for the US military history', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  ('1005', '1002', 'A', '1002 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1006', '1002', 'B', '1002 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1007', '1002', 'C', '1002 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1008', '1002', 'D', '1002 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  ('1009', '1003', 'A', '1003 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1010', '1003', 'B', '1003 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1011', '1003', 'C', '1003 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1012', '1003', 'D', '1003 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  ('1013', '1004', 'A', '1004 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1014', '1004', 'B', '1004 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1015', '1004', 'C', '1004 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1016', '1004', 'D', '1004 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  ('1017', '1005', 'A', '1005 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1018', '1005', 'B', '1005 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1019', '1005', 'C', '1005 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1020', '1005', 'D', '1005 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  ('1021', '1006', 'A', '1006 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1022', '1006', 'B', '1006 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1023', '1006', 'C', '1006 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1024', '1006', 'D', '1006 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),


  ('1025', '1007', 'A', '1007 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1026', '1007', 'B', '1007 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1027', '1007', 'C', '1007 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1028', '1007', 'D', '1007 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  ('1029', '1008', 'A', '1008 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1030', '1008', 'B', '1008 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1031', '1008', 'C', '1008 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1032', '1008', 'D', '1008 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  ('1033', '1009', 'A', '1009 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1034', '1009', 'B', '1009 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1035', '1009', 'C', '1009 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  ('1036', '1009', 'D', '1009 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-','') , '1010', 'A', '1010 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1010', 'B', '1010 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1010', 'C', '1010 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1010', 'D', '1010 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-','') , '1011', 'A', '1011 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1011', 'B', '1011 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1011', 'C', '1011 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1011', 'D', '1011 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-','') , '1012', 'A', '1012 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1012', 'B', '1012 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1012', 'C', '1012 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1012', 'D', '1012 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-','') , '1013', 'A', '1013 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1013', 'B', '1013 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1013', 'C', '1013 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1013', 'D', '1013 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-','') , '1014', 'A', '1014 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1014', 'B', '1014 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1014', 'C', '1014 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1014', 'D', '1014 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-','') , '1015', 'A', '1015 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1015', 'B', '1015 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1015', 'C', '1015 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1015', 'D', '1015 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-','') , '1016', 'A', '1016 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1016', 'B', '1016 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1016', 'C', '1016 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1016', 'D', '1016 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-','') , '1017', 'A', '1017 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1017', 'B', '1017 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1017', 'C', '1017 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1017', 'D', '1017 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-','') , '1018', 'A', '1018 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1018', 'B', '1018 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1018', 'C', '1018 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1018', 'D', '1018 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-','') , '1019', 'A', '1019 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1019', 'B', '1019 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1019', 'C', '1019 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1019', 'D', '1019 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),


  (replace(uuid(),'-','') , '1020', 'A', '1020 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1020', 'B', '1020 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1020', 'C', '1020 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1020', 'D', '1020 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-','') , '1021', 'A', '1021 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1021', 'B', '1021 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1021', 'C', '1021 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1021', 'D', '1021 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-','') , '1022', 'A', '1022 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1022', 'B', '1022 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1022', 'C', '1022 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1022', 'D', '1022 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-','') , '1023', 'A', '1023 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1023', 'B', '1023 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1023', 'C', '1023 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1023', 'D', '1023 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-','') , '1024', 'A', '1024 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1024', 'B', '1024 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1024', 'C', '1024 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1024', 'D', '1024 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),



  (replace(uuid(),'-','') , '1025', 'A', '1025 aaaa', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1025', 'B', '1025 bbbb', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1025', 'C', '1025 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1025', 'D', '1025 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1025', 'E', '1025 eeee', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1025', 'F', '1025 ffff', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1025', 'G', '1025 gggg', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1025', 'H', '1025 hhhh', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1025', 'I', '1025 iiii', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1025', 'J', '1025 jjjj', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1025', 'K', '1025 kkkk', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1025', 'L', '1025 llll', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),

  (replace(uuid(),'-','') , '1026', 'A', '1026 aaaa', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1026', 'B', '1026 bbbb', 1, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1026', 'C', '1026 cccc', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1026', 'D', '1026 dddd', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1026', 'E', '1026 eeee', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1026', 'F', '1026 ffff', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1026', 'G', '1026 gggg', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1026', 'H', '1026 hhhh', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1026', 'I', '1026 iiii', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1026', 'J', '1026 jjjj', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1026', 'K', '1026 kkkk', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0),
  (replace(uuid(),'-','') , '1026', 'L', '1026 llll', 0, '2017-07-11 16:22:30', '1', '2017-07-11 16:22:33', '1', '1', 1, 0)

;