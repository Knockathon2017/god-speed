var React = require('react');

var AddServiceForm = React.createClass({
    render: function(){
        return (
            <div>
                <form>
                    <div className="col-md-6 col-md-offset-3 stan-pad login-card">
                        <h2 className="form-heading">Add New</h2>
                        <div className="row pad-bottom border-bottom-black">
                            <div className="form-group col-md-8">
                                <input type="text" className="form-control" id="host" placeholder="Host"/>
                            </div>
                            <div className="form-group col-md-4">
                                <input type="text" className="form-control" id="port" placeholder="Port"/>
                            </div>
                            <span className="help-text pad-left">Press <span className="help-text-focus">'Tab'</span> to fetch host information</span>
                        </div>
                        <div className="row pad-top border-bottom-black">
                            <div className="form-group col-md-7">
                                <label htmlFor="exampleInputEmail1">URL</label>
                                <input type="text" className="form-control" id="host" placeholder="Host"/>
                            </div>
                            <div className="form-group col-md-5">
                                <label htmlFor="exampleInputEmail1">Log Path</label><br/>
                                <a href="#" className="status-text">/disk2/test.log</a>
                            </div>
                            <div className="form-group col-md-7">
                                <label htmlFor="exampleInputEmail1">Tags</label>
                                <input type="text" className="form-control" id="port" placeholder="Tags"/>
                            </div>
                            <div className="form-group col-md-5">
                                <label htmlFor="exampleInputEmail1">Status</label><br/>
                                <label htmlFor="status" className="status-text text-success">Status</label>
                            </div>
                        </div>
                        <div className="row pad-all border-bottom-black">
                            <span className="help-text">service_name : <span className="help-text-focus">Multiply</span></span><br/>
                            <span className="help-text">method_name : <span className="help-text-focus">/mul</span></span><br/><br/>
                            <table className="table table-hover">
                                <thead>
                                <tr>
                                    <th>name</th>
                                    <th className="param-type">type</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>p1</td>
                                        <td>int</td>
                                    </tr>
                                    <tr>
                                        <td>p2</td>
                                        <td>int</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div className="pad-top">
                            <button type="submit" className="btn btn-default">Cancel</button>
                            <button type="submit" className="btn btn-success pull-right">Add</button>
                        </div>
                    </div>
                </form>
            </div>
        );
    }
});

module.exports = AddServiceForm;