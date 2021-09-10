import React, { Component } from 'react'
import { Text, StyleSheet, View, Image } from 'react-native'
import { Input, Icon } from 'react-native-elements'
import { Button } from 'react-native-elements/dist/buttons/Button';
import { colors } from '../../utils';

class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {}
    }

    componentDidMount = () => {
        // fetch()
    }

    render() {
        const { navigation } = this.props
        return (
            <View style={styles.container}>
                <Image style={styles.image} source={require('../../assets/images/logo.png')} />

                <Input
                    placeholder='Email'
                    leftIcon={
                        <Icon
                            name='email'
                            type='material-icons'
                            size={24}
                            color={colors.primary}
                        />
                    }
                    inputContainerStyle={styles.input}
                />

                <Input
                    placeholder='Password'
                    secureTextEntry={true}
                    leftIcon={
                        <Icon
                            name='lock'
                            type='material-icons'
                            size={24}
                            color={colors.primary}
                        />
                    }
                    inputContainerStyle={styles.input}
                />
                <View style={styles.forgot}>
                    <Text>forgot password?</Text>
                </View>

                <Button
                    title="Login"
                    titleStyle={{ fontSize: 25, color: colors.regular }}
                    type="Solid"
                    containerStyle={styles.button}
                />

                <View style={styles.viewText}>
                    <Text
                        style={styles.text}
                        onPress={() => navigation.navigate('Register')}
                    >
                        Belum punya akun?
                    </Text>
                </View>
            </View>
        );
    }
}

export default Login;

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: colors.white,
        justifyContent: 'center',
        alignItems: 'center'
    },
    image: {
        width: 200,
        height: 200,
    },
    input: {
        marginHorizontal: 40,
    },
    button: {
        backgroundColor: colors.primary,
        width: '40%',
        borderRadius: 10,
        marginTop: 20
    },
    forgot: {
        // width: 300,
        alignSelf: 'flex-end',
        marginRight: 50,
    },
    viewText: {
        marginTop: 20,
    },
    text: {
        fontSize: 18
    }
})
