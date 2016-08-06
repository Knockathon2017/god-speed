var React = require('react');
var axios = require('axios');
var config = require('Config');

var {baseUrl, list, POST_CONFIG} = config;

var ServiceList = React.createClass({
    getInitialState: function () {
        return {
            data: []
        };
    },
    componentDidMount: function(){
        this.getList();
    },
    getList: function(){
        var that = this;
        axios.get(baseUrl+''+list,POST_CONFIG).then(function(res){
            that.setState({
                data:res.data
            });
        }, function(res){
            alert("error");
        });
    },
    onClickLog: function(evt){
        var el = $(evt.currentTarget);
        debugger
        var url = el.attr('url');
    },
    getProcessedUrl: function(a,b,c){
        var ip = a.data.IP;
        var methodName = a.data.methodUrl.replace(ip+'/',"");
        //var fun = methodName.substr();
        var url = ip.substr(0,ip.length-5);
        url = '/log?u='+url+':3232&m='+methodName;
        return url;
    },
    renderList: function(){
        var that = this;
        var data = $.map(this.state.data, function(obj){
            return ($.tmpl('<tr>\
                 <td>Host1</td>\
                 <td>${url}</td>\
                 <td>\
                 {{each tags}}\
                    ${this}, \
                 {{/each}}\
                 </td>\
                 <td><span class="text-success">Active</span></td>\
                 <td>\
                     <a href="#">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;\
                     <a href="{{html clickHandler(this, "eshu")}}" target="_blank" a="ref">Logs</a>&nbsp;&nbsp;&nbsp;&nbsp;\
                     <a href="#" class="text-danger">Remove</a>\
                 </td>\
             </tr>', $.extend({}, obj, {clickHandler: that.getProcessedUrl})));
        });
        var temp = $("<div id='temp'></div>");
        $.each(data, function(index, obj){
            temp.append(obj)
        });
        return temp.html();
    },
    render: function () {
        var data = this.state.data;
        return (
            <div>
                <div className="listing-screen">
                    <div className="col-md-12">
                        <div className="head-area">
                            <span></span><br/>
                            <h3 className="mrg0">My Services</h3>
                        </div>
                        <div>
                            <table className="table table-hover">
                                <thead>
                                <tr>
                                    <th>Host</th>
                                    <th>URL</th>
                                    <th className="table-tags">Tags</th>
                                    <th className="table-status">Status</th>
                                    <th className="table-actions"></th>
                                </tr>
                                </thead>
                                <tbody dangerouslySetInnerHTML={{__html: this.renderList()}}>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
});

module.exports = ServiceList;