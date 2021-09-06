import React, { Component } from 'react'
import { Text, StyleSheet, View } from 'react-native'

class HeaderComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() { 
        return ( 
            <View>
                <Text>Header Component</Text>
            </View>
         );
    }
}
 
export default HeaderComponent;

const styles = StyleSheet.create({})
