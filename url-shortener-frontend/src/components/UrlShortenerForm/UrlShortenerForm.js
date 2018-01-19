import React, { Component } from 'react';
import UrlList from '../UrlList';
import { getAllUrls, createUrl } from '../../api/urlApi'
import FlatButton from 'material-ui/FlatButton';
import TextField from 'material-ui/TextField';
import { ToastContainer, toast } from "react-toastify";

class UrlShortenerForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      value: '',
      urls: []
    };

    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange = name => event => {
    this.setState({
      [name]: event.target.value,
    })
  }


  handleSubmit(event) {
    createUrl(this.state.value)
      .then((response) => {
        this.setState({ urls: response.data });
      })
      .catch(() => {
        console.log(1)
        toast.error("Invalid URL!", {
          position: toast.POSITION.TOP_CENTER
        });
      })

    event.preventDefault();
  }

  componentWillMount() {
    getAllUrls()
      .then((response) => {
        this.setState({ urls: response.data })
      })
  }

  render() {
    return (
      <div>
        <ToastContainer autoClose={8000} />
        <form onSubmit={this.handleSubmit}>
          <TextField
              id="url"
              label="url"
              value={this.state.value}
              onChange={this.handleChange('value')}
            />
          <FlatButton
            label="Submit"
            primary={true}
            type='submit'
            onTouchTap={this.handleSubmit}
          />
          <UrlList urls={this.state.urls} />
        </form>


      </div>

    );
  }
}

export default UrlShortenerForm