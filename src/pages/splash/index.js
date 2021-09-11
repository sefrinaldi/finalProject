import React, { Component } from 'react'
import { Text, StyleSheet, View, Image } from 'react-native'
import { colors } from '../../utils'

class Splash extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }

    componentDidMount = () => {
        setTimeout(()=> {
            this.props.navigation.replace('Login')
        }, 3000)
    }

    render() { 
        return ( 
            <View style={styles.container}>
                <Image style={styles.image} source={require('../../assets/images/logo.png')} />
            </View>
         );
    }
}
 
export default Splash;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: colors.white,
        justifyContent: 'center',
        alignItems: 'center'
    },
    image: {
        width: 300,
        height: 300,
    }
})
