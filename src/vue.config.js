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
  devServer: {
    port: '8080',
    proxy: {
      '^/api': {
        target: 'http://localhost:8081',
        ws: true,
        changeOrigin: true
      },
    },
  },
  productionSourceMap: process.env.NODE_ENV !== 'production',
  lintOnSave: process.env.NODE_ENV !== 'production'
}