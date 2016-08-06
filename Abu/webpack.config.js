module.exports = {
    entry: './app/app.jsx',
    output: {
        path: __dirname,
        filename: './public/bundel.js'
    },
    resolve: {
        root: __dirname,
        alias: {
            Config: 'app/config/Config.jsx',
            Login: 'app/components/login/Login.jsx',
            LoginForm: 'app/components/login/LoginForm.jsx',
            Dashboard: 'app/components/dashboard/Dashboard.jsx',
            Header: 'app/components/dashboard/Header.jsx',
            SearchService: 'app/components/dashboard/SearchService.jsx',
            ServiceList: 'app/components/dashboard/ServiceList.jsx',
            AddService: 'app/components/dashboard/AddService.jsx',
            AddServiceForm: 'app/components/dashboard/AddServiceForm.jsx',
            LogDisplay: 'app/components/logs/LogDisplay.jsx'
        },
        extensions: ['','.js','.jsx']
    },
    module: {
        loaders: [
            {
                loader: 'babel-loader',
                query: {
                    presets: ['react', 'es2015', 'stage-0']
                },
                test: /\.jsx?$/,
                exclude: /(node_modules|bower_components)/
            }
        ]
    }
}