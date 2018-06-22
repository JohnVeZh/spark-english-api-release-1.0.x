
INSERT INTO `tb_paper_catalog` (`id`, `name`, `type`, `section_code`, `qr_code`, `parent_id`, `level`, `create_date`, `create_by`, `update_date`, `update_by`, `remarks`, `sort`, `del_flag`)
VALUES
  /*字幕听力2*/
  ('21', '字幕听力2分类1', 2, 1, NULL, '0', 1, '2017-07-11 09:43:52', '2', '2017-07-11 09:43:55', '2', '2', 2, 0),

  ('22', '字幕听力2分类2', 2, 1, NULL, '0', 1, '2017-07-11 09:43:52', '2', '2017-07-11 09:43:55', '2', '2', 2, 0),
  ('23', '字幕听力2分类3', 2, 1, NULL, '0', 1, '2017-07-11 09:43:52', '2', '2017-07-11 09:43:55', '2', '2', 2, 0),
  ('24', '字幕听力2分类4', 2, 1, NULL, '0', 1, '2017-07-11 09:43:52', '2', '2017-07-11 09:43:55', '2', '2', 2, 0);


insert  into `tb_paper_group`(`id`,`catalog_id`,`name`,`img`,`create_date`,`create_by`,`update_date`,`update_by`,`remarks`,`sort`,`del_flag`)
values
  ('21','21','CET4 201706','http://img.zcool.cn/community/05e5e1554af04100000115a8236351.jpg','2017-07-27 17:04:07','1','2017-07-27 17:04:10','1','1',0,0),
  ('22','21','CET4 201705','http://img4.duitang.com/uploads/item/201210/26/20121026191216_5sHEL.thumb.700_0.jpeg','2017-07-27 17:06:22','1','2017-07-27 17:06:26','1','1',0,0),
  ('23','21','CET4 201704','http://image.elegantliving.ceconline.com/320000/320100/20110815_03_52.jpg','2017-07-27 17:07:00','1','2017-07-27 17:07:03','1','1',0,0);

insert  into `tb_paper_group_relation`(`id`,`group_id`,`paper_id`,`create_date`,`create_by`,`update_date`,`update_by`,`remarks`,`sort`,`del_flag`)
values
  ('1','21','21','2017-07-28 14:45:51','1','2017-07-28 14:46:10','1',NULL,0,0),
  ('2','21','22','2017-07-28 14:46:26','1','2017-07-28 14:46:31','1',NULL,0,0),
  ('3','21','23','2017-07-28 14:48:03','1','2017-07-28 14:48:06','1',NULL,0,0),
  ('4','21','24','2017-07-28 14:48:19','1','2017-07-28 14:48:22','1',NULL,0,0),
  ('5','21','25','2017-07-28 14:48:40','1','2017-07-28 14:48:43','1',NULL,0,0);


/*Data for the table `tb_paper` */

insert  into `tb_paper`(`id`,`catalog_id`,`name`,`content_type`,`code`,`img`,`create_date`,`create_by`,`update_date`,`update_by`,`remarks`,`sort`,`del_flag`)
values
  ('21',NULL,'CET4 201706 字幕听力21',0,'1','1','2017-07-11 09:35:19','1','2017-07-11 09:35:23','1','1',0,0),
  ('22',NULL,'CET4 201706 字幕听力22',0,'2','2','2017-07-11 09:36:11','2','2017-07-11 09:36:14','2','2',0,0),
  ('23',NULL,'CET4 201706 字幕听力23',0,'3','3','2017-07-11 09:44:42','1','2017-07-11 09:44:49','3','3',0,0),
  ('24',NULL,'CET4 201706 字幕听力24',0,'4','4','2017-07-11 09:46:21','4','2017-07-11 09:46:25','4','4',0,0),
  ('25',NULL,'CET4 201706 字幕听力25',0,'5','5','2017-07-11 15:06:57','5','2017-07-11 15:07:13','5','5',5,0);

/*Data for the table `tb_paper_caption_listening` */

insert  into `tb_paper_caption_listening`(`id`,`paper_id`,`audio_url`,`subtitle_url`)
values
  ('21','21','http://o8c5o8act.bkt.clouddn.com/DTJ161M11.mp3','http://7xqc0j.com1.z0.glb.clouddn.com/test.lrc'),
  ('22','22','http://o8c5o8act.bkt.clouddn.com/DTJ161M10.MP3','http://7xqc0j.com1.z0.glb.clouddn.com/test.lrc'),
  ('23','23','http://o8c5o8act.bkt.clouddn.com/DTJ161M5.MP3','http://7xqc0j.com1.z0.glb.clouddn.com/test.lrc'),
  ('24','24','http://o8c5o8act.bkt.clouddn.com/DTJ161M6.MP3','http://7xqc0j.com1.z0.glb.clouddn.com/test.lrc'),
  ('25','25','http://o8c5o8act.bkt.clouddn.com/DTJ161M9.MP3','http://7xqc0j.com1.z0.glb.clouddn.com/test.lrc');

/*Data for the table `tb_paper_caption_listening_video` */

insert  into `tb_paper_caption_listening_video`(`id`,`paper_id`,`name`,`cc_id`)
values
  ('21','21','1','C76D937E8AAB1F5B9C33DC5901307461'),
  ('22','22','1','41F6FDD2DE2A53FA9C33DC5901307461'),
  ('23','23','1','70F41F0855868F489C33DC5901307461'),
  ('24','24','1','3BD0C80F48AB82B29C33DC5901307461'),
  ('25','25','1','ADE984C7C932AD789C33DC5901307461');
