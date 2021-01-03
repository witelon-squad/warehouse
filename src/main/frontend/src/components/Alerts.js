import React, { Component, Fragment } from 'react';
import { withAlert } from 'react-alert';
import { connect } from 'react-redux';

export class Alerts extends Component {

    componentDidUpdate(prevProps) {
        const { error, alert, message } = this.props;
        if (error !== prevProps.error) {
            if(error.status !== 404)
            for (const property in error.msg) {
                if ([error.msg.property]) alert.error(`${property} ${error.msg[property]}`)
            } else {
                if (error.status === 404) alert.error(`${error.status} PRODUCT DOESNT EXIST`)
            }
            
        }

        if (message !== prevProps.message) {
            if (message.addNewProduct) alert.success(message.addNewProduct);
            if (message.deleteProduct) alert.success(message.deleteProduct);
            if (message.updateProduct) alert.success(message.updateProduct);
        } 
    }

    render() {
        return <Fragment />;
    }
}

const mapStateToProps = state => ({
    error: state.errors,
    message: state.messages
});

export default connect(mapStateToProps)(withAlert()(Alerts));