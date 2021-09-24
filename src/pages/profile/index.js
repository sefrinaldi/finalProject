import React, { Component } from 'react'
import { Text, StyleSheet, View, Image } from 'react-native'
import { ListMenu } from '../../components';
import { dummyMenu } from '../../data/dummyMenu';
import { dummyProfile } from '../../data/dummyProfile';
import { colors } from '../../utils';

class Profile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            profile: dummyProfile,
            menus: dummyMenu
        }
    }
    render() {
        const { profile, menus } = this.state
        const { navigation } = this.props
        return (
            <View style={styles.page}>
                <View style={styles.container}>
                    <Image source={profile.avatar} style={styles.foto} />
                    <View style={styles.profile}>
                        <Text style={styles.name}>{profile.name}</Text>
                        <Text style={styles.desc}>No Hp. {profile.hp}</Text>
                        <Text style={styles.desc}>{profile.alamat}</Text>
                        <Text style={styles.desc}>{profile.kota}</Text>
                    </View>
                    <ListMenu menus={menus} navigation={navigation}/>
                </View>
            </View>
        );
    }
}

export default Profile;

const styles = StyleSheet.create({
    page: {
        flex: 1,
        backgroundColor: colors.regular
    },
    container: {
        position: 'absolute',
        height: 500,
        bottom: 0,
        backgroundColor: colors.white,
        width: '100%',
        borderTopLeftRadius: 40,
        borderTopRightRadius: 40
    },
    foto: {
        width: 150,
        height: 150,
        borderRadius: 40,
        alignSelf: 'center',
        marginTop: -75
    },
    profile: {
        alignItems: 'center',
        marginTop: 10
    },
    name: {
        fontSize: 20,
        fontWeight: 'bold',
        marginBottom: 5
    },
    desc: {
        fontSize: 15
    }
})
