
import React from 'react';
import ReactDOM from 'react-dom';

import App from './App';
import Main from './components/Main';
import {Router, Route, browserHistory } from 'react-router-3';

ReactDOM.render(
<Router history={browserHistory}>
  <Route component={App}>
      <Route path="/" component={Main} />
  </Route>
</Router>,
document.getElementById('root'));