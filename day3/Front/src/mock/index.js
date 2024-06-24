import Mock from 'mockjs';

Mock.mock('https://localhost:8080/product/search', {
  "ret": 0,
  "data": {
    "mtime": "@datetime", //随机生成时间
    "score|1-800": 1,   //1-800之间随机生成一个随机数
    "nickname": "@cname",   //随机生成一个中文名
    "img": "@image('200x100', '#ffcc33', '#FFF', 'jpg', 'Fast Mock')"  //生成一个图片
  }
});
