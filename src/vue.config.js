const path = require("path");
module.exports = {
  runtimeCompiler: true,

  configureWebpack: {
    resolve: {
      alias: {
        '@': path.resolve(__dirname, 'src/'),
      }
    },
  },
  css: {
    sourceMap: false
  },
  productionSourceMap: process.env.NODE_ENV !== 'production',
  lintOnSave: process.env.NODE_ENV !== 'production'
};