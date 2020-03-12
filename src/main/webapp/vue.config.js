// vue.config.js
module.exports = {
    devServer: {
        port: 8180,
        proxy: 'http://localhost:8080'
    },
    outputDir: "../resources/META-INF/resources",
    productionSourceMap: false
};