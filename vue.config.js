const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  chainWebpack: config => {
    config.plugin('define').tap(definitions => {
        Object.assign(definitions[0]['process.env'], {
          NODE_HOST: '"http://localhost:8888"',
          //NODE_HOST: '"http://8.130.8.124:8888"',
          //NODE_HOST: '"8.130.8.124:8888"',   http头都不加，能访问到嘛！
          // NODE_HOST: '"http://192.168.1.106:8888"',
        });
        return definitions;
    });
  }
})
