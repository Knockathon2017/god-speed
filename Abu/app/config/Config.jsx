var config = {};

config.baseUrl = 'http://172.16.1.61:8080';
config.loginUrl = '/login';
config.info = '/info';
config.saveService = '/save';
config.list = '/list';
config.POST_CONFIG = {
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    }
};

module.exports = config;