var React = require('react');
var axios = require('axios');
var config = require('Config');
import { WithContext as ReactTags } from 'react-tag-input';

var {baseUrl, info} = config;
var infoUrl = baseUrl+""+info;

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
    getTagList: function(tags){
        var result = [];
        if(tags.length > 0){
            tags.forEach(function(obj,index){
                result.push({id:index,text:obj})
            });
        }
        return result;
    },
    onClickCancel: function(evt){
        console.log("close popup");
    },
    onClickSave: function(evt){

    },
    onBlurHandler: function(evt){
        var url = this.refs.urlTxt.value.trim();
        var that = this;
        debugger;
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
                            <div className="form-group col-md-8">
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
                            <div className="form-group col-md-7">
                                <label htmlFor="exampleInputEmail1">Tags</label>
                                <ReactTags tags={tags}
                                           handleDelete={this.handleDelete}
                                           handleAddition={this.handleAddition} />
                            </div>
                        </div>
                        <div className="row pad-all border-bottom-black">
                            <span className="help-text">service_name : <span className="help-text-focus">{this.state.serviceName}</span></span><br/>
                            <span className="help-text">method_name : <span className="help-text-focus">{this.state.functionName}</span></span><br/><br/>
                            <table className="table table-hover">
                                <thead>
                                <tr>
                                    <th>name</th>
                                    <th className="param-type">type</th>
                                </tr>
                                </thead>
                                <tbody>
                                {
                                    params.map(function(obj,index){
                                        return (
                                            <tr>
                                                <td>{obj.name}</td>
                                                <td>{obj.type}</td>
                                            </tr>
                                        );
                                    })
                                }
                                </tbody>
                            </table>
                        </div>
                        <div className="pad-top">
                            <button type="submit" className="btn btn-default" onClick={this.onClickCancel}>Cancel</button>
                            <button type="submit" className="btn btn-success pull-right" onClick={this.onClickSave}>Add</button>
                        </div>
                    </div>
                </form>
            </div>
        );
    }
});

module.exports = AddServiceForm;