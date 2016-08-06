var React = require('react');
var axios = require('axios');
var config = require('Config');
import { WithContext as ReactTags } from 'react-tag-input';

var {baseUrl, info, saveService, POST_CONFIG} = config;
var infoUrl = baseUrl+""+info;
//POST_CONFIG.headers.Authorization = '57a4e7bf1dbc234dc145933f';

var AddServiceForm = React.createClass({
    getInitialState: function(){
        return {
            serviceUrl: "",
            logPath: "",
            tags: [],
            serviceName: "",
            functionName: "",
            params: []
        };
    },
    getTagList: function(tags, bPlane){
        var result = [];
        if(bPlane){
            tags.forEach(function(obj,index){
                result.push(obj.text);
            });
        }else if(tags.length > 0){
            tags.forEach(function(obj,index){
                result.push({id:index,text:obj})
            });
        }
        return result;
    },
    getPostJsonData: function(){
         var that = this;
        return {
            "ip": that.state.serviceUrl,
            "port": "",
            "url": that.state.serviceUrl+""+config.info,
            "logPath": that.state.logPath,
            "status": "",
            "tags": that.getTagList(that.state.tags, true),
            "methodUrl": that.state.serviceUrl+""+that.state.functionName,
            "serviceName": that.state.serviceName
        };
    },
    onClickCancel: function(evt){
        $(".ReactTags__tag").remove();
        this.refs.sName.value = '';
        this.refs.fName.value = '';
        this.setState({
            serviceUrl: "",
            logPath: "",
            tags: [],
            serviceName: "",
            functionName: "",
            params:[]
        });
    },
    onClickSave: function(evt){
        var that = this;
        axios.post(baseUrl+''+saveService,this.getPostJsonData(),POST_CONFIG).then(function(res){
            that.props.onSuccessAddingService();
            $('#myModal').modal('hide');
        }, function(res){
            alert("error");
        });
    },
    onBlurHandler: function(evt){
        var url = this.refs.urlTxt.value.trim();
        var that = this;
        axios.get(url+""+config.info).then(function(res){
            var {methods, service_name,tags} = res.data;
            var tagList = that.getTagList(tags);
            var mName = methods.name;
            var params = methods.params;
            that.setState({
                serviceUrl: url,
                logPath: ('/logs/name:'+(methods.name.substr(1, methods.name.length))),
                tags: tagList,
                serviceName: service_name,
                functionName: mName,
                params: params
            });
        }, function(res){
            console.log("-----error------");
        });
    },
    handleDelete: function(i){
        var tags = this.state.tags;
        tags.splice(i, 1);
        this.setState({tags: tags});
    },
    handleAddition: function(tag){
        var tags = this.state.tags;
        tags.push({
            id: tags.length + 1,
            text: tag
        });
        this.setState({tags: tags});
    },
    render: function(){
        var tags = this.state.tags;
        var params = this.state.params;
        return (
            <div>
                <form>
                    <div className="stan-pad login-card margin-remove-top-bottom">
                        <h2 className="form-heading">Add New</h2>
                        <div className="row pad-bottom border-bottom-black">
                            <div className="form-group col-md-12">
                                <input type="text" className="form-control" id="host" placeholder="Host" ref="urlTxt" onBlur={this.onBlurHandler}/>
                            </div>
                            <span className="help-text pad-left">Press <span className="help-text-focus">'Tab'</span> to fetch host information</span>
                        </div>
                        <div className="row pad-top border-bottom-black">
                            <div className="form-group col-md-7">
                                <label htmlFor="exampleInputEmail1">URL</label>
                                <input type="text" className="form-control" id="host" placeholder="Host" readOnly value={this.state.serviceUrl}/>
                            </div>
                            <div className="form-group col-md-5">
                                <label htmlFor="exampleInputEmail1">Log Path</label><br/>
                                <input type="text" className="form-control" placeholder="Log Path" value={this.state.logPath}/>
                            </div>
                            <div className="form-group col-md-12">
                                <label htmlFor="exampleInputEmail1">Tags</label>
                                <ReactTags tags={tags}
                                           handleDelete={this.handleDelete}
                                           handleAddition={this.handleAddition} />
                            </div>
                        </div>
                        <div className="row pad-all border-bottom-black">
                            <span className="help-text">service_name : <span className="help-text-focus" ref="sName">{this.state.serviceName}</span></span><br/>
                            <span className="help-text">method_name : <span className="help-text-focus" ref="fName">{this.state.functionName}</span></span><br/><br/>
                            <table className="table table-hover">
                                <thead>
                                <tr>
                                    <th>name</th>
                                    <th className="param-type">type</th>
                                </tr>
                                </thead>
                                <tbody>
                                {
                                    Object.keys(params).map(function(obj){
                                        return (
                                            <tr>
                                                <td>{params[obj].name}</td>
                                                <td>{params[obj].type}</td>
                                            </tr>
                                        );
                                    })
                                }
                                </tbody>
                            </table>
                        </div>
                        <div className="pad-top">
                            <button type="submit" className="btn btn-default" data-dismiss="modal" onClick={this.onClickCancel}>Cancel</button>
                            <button type="submit" className="btn btn-success pull-right" onClick={this.onClickSave}>Add</button>
                        </div>
                    </div>
                </form>
            </div>
        );
    }
});

module.exports = AddServiceForm;