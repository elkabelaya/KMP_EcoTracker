const CopyWebpackPlugin = require('copy-webpack-plugin');
const webpack = require('webpack');
const path = require('path');

config.resolve.fallback = {
    ...config.resolve.fallback,
    "fs": false,
    "path": false,
    "crypto": false
};
if (config.devServer) {
    config.devServer.static = config.devServer.static || [];
    config.devServer.static.push({
        directory: path.resolve(__dirname, '../../../../webApp/build/processedResources/js/main')
    });
}

const sqljsDistPath = path.dirname(require.resolve('sql.js/package.json'));
const sqlitePackageDir = path.dirname(require.resolve('@sqlite.org/sqlite-wasm'));


config.watchOptions = {
    aggregateTimeout: 300,
    poll: 1000,
    ignored: /node_modules/
};


config.plugins.push(
    new CopyWebpackPlugin({
        patterns: [
            {
                from: path.join(sqljsDistPath, 'dist', 'sql-wasm.wasm'),
                to: '.'
            },
            {
                from: path.join(sqlitePackageDir,  'index.mjs'),
                to: 'sqlite3.js'
            },
            {
                from: path.join(sqlitePackageDir, 'sqlite3.wasm'),
                to: 'sqlite3.wasm'
            },
        ]
    })
);

if (config.devServer) {
    config.devServer.devMiddleware = {
        writeToDisk: true
    };
}
