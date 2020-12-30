import React, { Component, Fragment } from 'react'

export class MinorForm extends Component {

    state = {
        subValues: {}
    }

    componentDidUpdate(previousProps) {
        if (previousProps.type !== this.props.type) {
            switch (this.props.type) {
                case "gpu":
                    this.setState({
                        subValues: {
                            layout: '',
                            typeOfMemory: '',
                            vram: ''
                        }
                    })
                    break;
                case "cpu":
                    this.setState({
                        subValues: {
                            cache: '',
                            cores: '',
                            series: '',
                            timing: ''
                        }
                    })
                    break;
            }
        }
    }

    onChange = e => {
        this.setState(prevState => ({
            subValues: {
                ...prevState.subValues,
                [e.target.name]: e.target.value
            }
        }))
    }

    render() {
        return (
            <Fragment>
                {this.props.type && Object.keys(this.state.subValues).map(keyName => (
                    <div className='form-group' key={keyName}>
                        <label>{keyName}</label>
                        <input
                            className='form-control'
                            type='text'
                            name={keyName}
                            value={this.state.keyName}
                            onChange={this.onChange}
                        />
                    </div>
                ))}
            </Fragment>
        )
    }
}

export default MinorForm
