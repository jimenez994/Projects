import React from 'react';
import Grid from "@material-ui/core/Grid";
import withStyles from '@material-ui/core/styles/withStyles';

const style ={
  grid : {
    margin: "0 -15px",
    width: "calc(100% + 30px)",
    

  }
}

function GridContainer({...props}){
  const { classes, children, className, ...rest } = props;
  return(
    <Grid container {...rest} className={classes.grid + " " + className}>
      {children}
    </Grid>
  );
}

export default withStyles(style)(GridContainer);