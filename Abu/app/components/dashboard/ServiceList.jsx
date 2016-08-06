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
    renderList: function(){
        <tr>
            <td>Host1</td>
            <td>URL1</td>
            <td>Tag1, Tag2, Tag3</td>
            <td><span class="text-success">Active</span></td>
            <td>
                <a href="#">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="#">Logs</a>&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="#" class="text-danger">Remove</a>
            </td>
        </tr>

        debugger
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
                     <a href="${url}" target="_blank">Logs</a>&nbsp;&nbsp;&nbsp;&nbsp;\
                     <a href="#" class="text-danger">Remove</a>\
                 </td>\
             </tr>', obj));
        });
        var temp = $("<div id='temp'></div>");
        $.each(data, function(index, obj){
            temp.append(obj)
        });
        return temp.html();
    },
    render: function () {
        var data = this.state.data;
        debugger
        return (
            <div>
                <div className="listing-screen">
                    <div className="col-md-12">
                        <div className="head-area">
                            <div className="pull-right">
                                <button className="btn btn-success pull-right margin-right">Add New</button>
                                <form className="form-inline pull-right margin-right">
                                    <div className="form-group">
                                        <input type="text" className="form-control" placeholder="Search"/>
                                    </div>
                                </form>
                            </div>
                            <span>Home</span><br/>
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