
import App from './App';
import {Router, Route, Link, browserHistory } from 'react-router';
import PropTypes from 'prop-types';
import Bootstrap from 'bootstrap/dist/css/bootstrap.css';

ReactDOM.render(
<Router history={browserHistory}>
  <Route component={App}>
      <Route path="/" component={App} />
  </Route>
</Router>,
document.getElementById('app'));