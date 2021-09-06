import React, { Component } from 'react'
import { Text, StyleSheet, View } from 'react-native'
import { HeaderComponent } from '../../components';

class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    render() { 
        return ( 
            <View style={styles.container}>
                <View>
                    <HeaderComponent />
                </View>
            </View>
         );
    }
}
 
export default Home;

const styles = StyleSheet.create({
    container: {}
})
