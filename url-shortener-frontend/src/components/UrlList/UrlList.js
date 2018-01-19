import React, { Component } from 'react';
import FlatButton from 'material-ui/FlatButton';
import { Table, TableHeaderColumn, TableRow, TableHeader, TableRowColumn, TableBody } from 'material-ui/Table';
import { removeUrl } from '../../api/urlApi'

class UrlList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      urls: []
    };
  }

  handleDelete(item) {
    removeUrl(item.id)
      .then((response) => {
        const newState = this.state.urls.slice();
        if (newState.indexOf(item) > -1) {
          newState.splice(newState.indexOf(item), 1);
          this.setState({ urls: newState })
        }
      })

  }

  componentWillReceiveProps(nextProps) {
    this.setState({ urls: nextProps.urls })
  }

  render() {
    let messageNodes

    messageNodes = this.state.urls.map((url, index) => {
      return (
        <TableRow key={index} selectable={false} >
          <TableRowColumn><a href={url.url} target="_blank">{url.shortened}</a></TableRowColumn>
          <TableRowColumn style={{textAlign: 'right'}}><FlatButton
            label="Remove"
            primary={true}
            onClick={this.handleDelete.bind(this, url)}
          />
          </TableRowColumn>
        </TableRow>
      );
    });

    return (
      <Table selectable={false}>
        <TableHeader displaySelectAll={false} adjustForCheckbox={false}>
          <TableRow>
            <TableHeaderColumn>shortened</TableHeaderColumn>
            <TableHeaderColumn></TableHeaderColumn>
          </TableRow>
        </TableHeader>
        <TableBody displayRowCheckbox={false}>
          {messageNodes}
        </TableBody>
      </Table>
    );
  }
}

export default UrlList;